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
@Table(name = "CONTENT_ITEM")
public class ContentItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE_ITEM")
    private String titleItem;

    @Column(name = "LAYOUT_SIZE")
    private Long layoutSize;

    @OneToMany(targetEntity = TextItem.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "CONTENT_ITEM_ID", referencedColumnName = "id")
    @OrderBy("position asc")
    private List<TextItem> textItemList;

}
