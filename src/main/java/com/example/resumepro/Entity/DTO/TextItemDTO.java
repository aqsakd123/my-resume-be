package com.example.resumepro.Entity.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TextItemDTO {
    private Long id;

    private Long layout;

    private Long typeTextInput;

    private Long fontWeight;

    private Long fontSize;

    private Long position;

    private String textContent;

}
