package com.example.resumepro.Entity.DTO;

import com.example.resumepro.Entity.TextItem;
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
public class ContentItemDTO {

    private Long id;

    private String titleItem;

    private Long layoutSize;

    private List<TextItemDTO> textItemList;

}
