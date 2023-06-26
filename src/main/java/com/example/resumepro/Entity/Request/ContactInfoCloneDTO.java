package com.example.resumepro.Entity.Request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactInfoCloneDTO {

    private String name;
    private String summary;
    private String location;
    private String phoneNumber;
    private String email;
    private String github;
    private String linkedln;
    private String image;

}
