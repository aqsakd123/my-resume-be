package com.example.resumepro.Entity.DTO;

import com.example.resumepro.Entity.ContactInfo;
import com.example.resumepro.Entity.ResumeContentItem;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResumeDTO {

    private Long id;

    private String uuid;

    private String name;

    private Long isTemplate = 0L; //0: No, 1: Yes

    private String fontFamily;

    private String backgroundImageURL;

    private String coverImageURL;

    private String coverColor;

    private Long coverTransparent;

    private String resumeTitle;

    private String createdBy;

    private Date  createdAt;

    private Date modifiedAt;

    private String modifiedBy;

    private Long status = 1L; //0: deleted, 1: alive

    private ContactInfoDTO contactInfo;

    private List<ResumeContentItemDTO> resumeContentItemList;

}
