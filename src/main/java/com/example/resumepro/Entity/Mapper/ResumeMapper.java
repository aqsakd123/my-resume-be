package com.example.resumepro.Entity.Mapper;

import com.example.resumepro.Entity.DTO.ResumeDTO;
import com.example.resumepro.Entity.Request.ResumeCloneDTO;
import com.example.resumepro.Entity.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResumeMapper {
    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    ResumeDTO toDTO(Resume tag);
    Resume toEntity(ResumeDTO dto);
    List<ResumeDTO> toListDTO(List<Resume> listTag);
    List<Resume> toListEntities(List<ResumeDTO> listDTO);

    ResumeCloneDTO toCloneDTO(Resume tag);
    Resume cloneToEntity(ResumeCloneDTO dto);

}
