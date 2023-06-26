package com.example.resumepro.Controller;

import com.example.resumepro.Config.AppException;
import com.example.resumepro.Entity.DTO.ResumeDTO;
import com.example.resumepro.Entity.DTO.UserDTO;
import com.example.resumepro.Entity.Request.ChangeRequestDTO;
import com.example.resumepro.Entity.Request.ResumeFilter;
import com.example.resumepro.Entity.Resume;
import com.example.resumepro.Repository.ResumeRepository;
import com.example.resumepro.Service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/resume")
@Slf4j
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        Authentication authen = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authen.getAuthorities());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ResumeDTO resume){
        return ResponseEntity.ok(resumeService.add(resume));
    }

    @PostMapping("/detail/{id}")
//    @PostAuthorize("authentication.principal.username == returnObject.body.createdBy")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(resumeService.detail(id));
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("authentication.principal.username == #resume.createdBy")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ResumeDTO resume){
        return ResponseEntity.ok(resumeService.update(id, resume));
    }

    @PostMapping("/detail-uuid/{uuid}")
    public ResponseEntity<?> detailUuid(@PathVariable("uuid") String id){
        return ResponseEntity.ok(resumeService.detailUUID(id));
    }

    @PostMapping("/filter")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<?> filter(@RequestBody ResumeFilter filter){
        return ResponseEntity.ok(resumeService.list(filter));
    }

    @PostMapping("/change-status-resume")
    public ResponseEntity<?> changeStatus(@RequestBody ChangeRequestDTO requestDTO){
        return ResponseEntity.ok(resumeService.changeStatus(requestDTO));
    }

    @PostMapping("/clone/{id}")
    @PreAuthorize("authentication.principal.username == #resume.createdBy")
    public ResponseEntity<?> clone(@PathVariable("id") Long id, @RequestBody ResumeDTO resume){
        return ResponseEntity.ok(resumeService.clone(id));
    }

}
