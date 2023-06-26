package com.example.resumepro.Service;

import com.example.resumepro.Entity.Request.CredenticalsDTO;
import com.example.resumepro.Entity.DTO.UserDTO;

public interface AuthenticationService {

    UserDTO login(CredenticalsDTO credentialsDto);
    UserDTO register(CredenticalsDTO userDto);
    UserDTO findByLogin(String login);

}
