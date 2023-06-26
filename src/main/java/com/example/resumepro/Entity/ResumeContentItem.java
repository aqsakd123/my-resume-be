package com.example.resumepro.Entity;


import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "RESUME_CONTENT_ITEM")
public class ResumeContentItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE_CONTENT_ITEM")
    private Long typeContentItem;

    @Column(name = "NAME_CONTENT_ITEM")
    private String nameContentItem;

    @Column(name = "POSITION")
    private Long position;

    @Column(name = "ICON_CONTENT_ITEM")
    private String iconContentItem;

    @Column(name = "LAYOUT_TOTAL_SIZE")
    private Long layoutTotalSize;

    @OneToMany(targetEntity = ContentItem.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "RESUME_CONTENT_ITEM_ID", referencedColumnName = "id")
    private List<ContentItem> contentItemList;

}
