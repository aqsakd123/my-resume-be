package com.example.resumepro.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "TEXT_ITEM")
public class TextItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LAYOUT_SIZE")
    private Long layout;

    @Column(name = "TYPE_TEXT_INPUT")
    private Long typeTextInput;

    @Column(name = "FONT_WEIGHT")
    private Long fontWeight;

    @Column(name = "FONT_SIZE")
    private Long fontSize;

    @Column(name = "POSITION")
    private Long position;

    @Column(name = "TEXT_CONTENT", columnDefinition = "LONGTEXT")
    private String textContent;

}
