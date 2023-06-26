package com.example.resumepro.Service;

import com.example.resumepro.Entity.DTO.ResumeDTO;
import com.example.resumepro.Entity.Request.ChangeRequestDTO;
import com.example.resumepro.Entity.Request.ResumeFilter;

import java.util.List;

public interface ResumeService {

    ResumeDTO add(ResumeDTO resume);

    ResumeDTO update(Long id, ResumeDTO resume);

    ResumeDTO detail(Long id);

    ResumeDTO detailUUID(String uuid);

    List<ResumeDTO> list(ResumeFilter filter);

    ChangeRequestDTO changeStatus(ChangeRequestDTO requestDTO);

    ResumeDTO clone(Long id);

}
