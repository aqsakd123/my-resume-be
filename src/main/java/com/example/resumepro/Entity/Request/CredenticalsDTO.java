package com.example.resumepro.Entity.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredenticalsDTO {

        @NotNull
        private String username;

        private String email;

        @NotNull
        private char[] password;

}
