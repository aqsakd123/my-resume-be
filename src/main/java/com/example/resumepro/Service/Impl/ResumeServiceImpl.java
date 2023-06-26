package com.example.resumepro.Service.Impl;

import com.example.resumepro.Config.AppException;
import com.example.resumepro.Entity.DTO.ResumeDTO;
import com.example.resumepro.Entity.DTO.UserDTO;
import com.example.resumepro.Entity.Mapper.ResumeMapper;
import com.example.resumepro.Entity.Request.ChangeRequestDTO;
import com.example.resumepro.Entity.Request.ResumeCloneDTO;
import com.example.resumepro.Entity.Request.ResumeFilter;
import com.example.resumepro.Entity.Resume;
import com.example.resumepro.Repository.ResumeRepository;
import com.example.resumepro.Service.ResumeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    private ResumeMapper resumeMapper = Mappers.getMapper(ResumeMapper.class);

    @Override
    public ResumeDTO add(ResumeDTO resume) {
        resume.setUuid(UUID.randomUUID().toString());
        resume.setStatus(1L);
        Resume res = resumeRepository.save(resumeMapper.toEntity(resume));
        return ResumeDTO.builder()
                .id(res.getId())
                .build() ;
    }

    @Override
    public ResumeDTO update(Long id, ResumeDTO resume) {
        Resume res = resumeRepository.findById(id)
                .orElseThrow(() -> new AppException("UNKNOWN_ID", HttpStatus.UNAUTHORIZED));
        resumeRepository.save(resumeMapper.toEntity(resume));
        return ResumeDTO.builder()
                .id(res.getId())
                .build() ;
    }

    @Override
    public ResumeDTO detail(Long id) {
        Resume res = resumeRepository.findById(id)
                .orElseThrow(() -> new AppException("UNKNOWN_ID", HttpStatus.UNAUTHORIZED));
        return resumeMapper.toDTO(res);
    }

    @Override
    public ResumeDTO detailUUID(String uuid) {
        Resume res = resumeRepository.findByUuid(uuid)
                .orElseThrow(() -> new AppException("UNKNOWN_ID", HttpStatus.UNAUTHORIZED));
        return resumeMapper.toDTO(res);
    }

    @Override
    public List<ResumeDTO> list(ResumeFilter filter) {
        Authentication authen = SecurityContextHolder.getContext().getAuthentication();
        if (authen != null && authen.isAuthenticated()){
            UserDTO user = (UserDTO) authen.getPrincipal();
            filter.setAuthor(user.getUsername());
        }

        Specification<Resume> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.hasLength(filter.getUuid())){
                predicates.add(criteriaBuilder.equal(root.get("uuid"), filter.getUuid()));
            } else {
                predicates.add(criteriaBuilder.greaterThan(root.get("status"), 0L ));
            }
            if(filter.getAuthorType() != null && filter.getAuthorType() == 1L){
                predicates.add(criteriaBuilder.equal(root.get("createdBy"),filter.getAuthor() ));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        List<Resume> res = resumeRepository.findAll(specification).stream()
                .map((item) -> {
                    return Resume.builder()
                            .id(item.getId())
                            .name(item.getName())
                            .resumeTitle(item.getResumeTitle())
                            .createdBy(item.getCreatedBy())
                            .status(item.getStatus())
                            .build();
                }).collect(Collectors.toList());
        return resumeMapper.toListDTO(res);
    }

    @Override
    public ChangeRequestDTO changeStatus(ChangeRequestDTO requestDTO) {
        Resume res = resumeRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new AppException("UNKNOWN_ID", HttpStatus.UNAUTHORIZED));
        if (requestDTO.getAction().equals("delete")) {
            res.setStatus(0L);
        }
        if (requestDTO.getAction().equals("undo")) {
            res.setStatus(1L);
        }
        resumeRepository.save(res);
        return requestDTO;
    }

    @Override
    public ResumeDTO clone(Long id) {
        Resume source = resumeRepository.findById(id)
                .orElseThrow(() -> new AppException("UNKNOWN_ID", HttpStatus.UNAUTHORIZED));
        ResumeDTO result = resumeMapper.toDTO(resumeMapper.cloneToEntity(resumeMapper.toCloneDTO(source)));
        return add(result);
    }

}
