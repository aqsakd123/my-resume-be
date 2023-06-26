package com.example.resumepro.Repository;

import com.example.resumepro.Entity.DTO.ResumeDTO;
import com.example.resumepro.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {

    Optional<Resume> findByUuid(String uuid);

}
