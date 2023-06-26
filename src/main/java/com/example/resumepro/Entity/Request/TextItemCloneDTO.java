package com.example.resumepro.Entity.Request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TextItemCloneDTO {

    private Long layout;

    private Long typeTextInput;

    private Long fontWeight;

    private Long fontSize;

    private Long position;

    private String textContent;

}
