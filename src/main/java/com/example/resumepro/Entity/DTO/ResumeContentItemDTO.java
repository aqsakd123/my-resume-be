package com.example.resumepro.Entity.DTO;

import com.example.resumepro.Entity.ContentItem;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResumeContentItemDTO {

    private Long id;

    private Long typeContentItem;

    private String nameContentItem;

    private Long position;

    private String iconContentItem;

    private Long layoutTotalSize;

    private List<ContentItemDTO> contentItemList;

}
