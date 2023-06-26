package com.example.resumepro.Entity.Request;

import com.example.resumepro.Entity.ContactInfo;
import com.example.resumepro.Entity.DTO.ContactInfoDTO;
import com.example.resumepro.Entity.DTO.ResumeContentItemDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResumeCloneDTO {

    private String name;

    private Long isTemplate = 0L; //0: No, 1: Yes

    private String fontFamily;

    private String backgroundImageURL;

    private String coverImageURL;

    private String coverColor;

    private Long coverTransparent;

    private String resumeTitle;

    private String createdBy;

    private Date createdAt;

    private Date modifiedAt;

    private String modifiedBy;

    private Long status; //0: deleted, 1: alive

    private ContactInfoCloneDTO contactInfo;

    private List<ResumeContentItemCloneDTO> resumeContentItemList;

}
