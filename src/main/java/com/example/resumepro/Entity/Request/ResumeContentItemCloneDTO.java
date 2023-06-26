package com.example.resumepro.Entity.Request;

import com.example.resumepro.Entity.DTO.ContentItemDTO;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResumeContentItemCloneDTO {

    private Long typeContentItem;

    private String nameContentItem;

    private Long position;

    private String iconContentItem;

    private Long layoutTotalSize;

    private List<ContentItemCloneDTO> contentItemList;

}
