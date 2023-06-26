package com.example.resumepro.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "RESUME")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class Resume {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UU_ID")
    private String uuid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_TEMPLATE")
    private Long isTemplate = 0L; //0: No, 1: Yes

    @Column(name = "FONT_FAMILY")
    private String fontFamily;

    @Column(name = "BACKGROUND_IMAGE_URL")
    private String backgroundImageURL;

    @Column(name = "COVER_IMAGE_URL")
    private String coverImageURL;

    @Column(name = "COVER_COLOR")
    private String coverColor;

    @Column(name = "COVER_TRANSPARENT")
    private Long coverTransparent;

    @Column(name = "RESUME_TITLE")
    private String resumeTitle;

    @Column(name = "CREATED_BY")
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_AT")
    @CreatedDate
    private Date createdAt;

    @Column(name = "MODIFIED_AT")
    @LastModifiedDate
    private Date modifiedAt;

    @Column(name = "MODIFIED_BY")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "STATUS")
    private Long status = 1L; //0: deleted, 1: alive

    @OneToOne(targetEntity = ContactInfo.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "RESUME_ID", referencedColumnName = "id")
    private ContactInfo contactInfo;

    @OneToMany(targetEntity = ResumeContentItem.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "RESUME_ID", referencedColumnName = "id")
    @OrderBy("position asc")
    private List<ResumeContentItem> resumeContentItemList;

}
