package com.example.resumepro.Entity.Request;

import com.example.resumepro.Entity.DTO.TextItemDTO;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContentItemCloneDTO {

    private String titleItem;

    private Long layoutSize;

    private List<TextItemCloneDTO> textItemList;

}
