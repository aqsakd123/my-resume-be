package com.example.resumepro.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "CONTACT_INFO")
public class ContactInfo implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUMMARY", columnDefinition = "LONGTEXT")
    private String summary;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "PHONE_NUMBER_STRING")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GITHUB")
    private String github;

    @Column(name = "LINKEDLN")
    private String linkedln;

    @Column(name = "IMAGE", columnDefinition = "LONGTEXT")
    private String image;

}
