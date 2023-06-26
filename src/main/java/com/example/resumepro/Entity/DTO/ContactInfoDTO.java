package com.example.resumepro.Entity.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactInfoDTO {

    private Long id;
    private String name;
    private String summary;
    private String location;
    private String phoneNumber;
    private String email;
    private String github;
    private String linkedln;
    private String image;

}
