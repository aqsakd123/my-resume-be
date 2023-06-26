package com.example.resumepro.Controller;

import com.example.resumepro.Config.UserAuthenticationProvider;
import com.example.resumepro.Entity.DTO.UserDTO;
import com.example.resumepro.Entity.Request.CredenticalsDTO;
import com.example.resumepro.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/signIn")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid CredenticalsDTO credentialsDto) {
        UserDTO userDto = authenticationService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getUsername(), userDto.getRoles()));
        userDto.setRefreshToken(userAuthenticationProvider.createRefreshToken(userDto.getUsername()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid CredenticalsDTO user) {
        UserDTO createdUser = authenticationService.register(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserDTO> refresh(@RequestBody @Valid UserDTO userDto) {
        // To Do: Check validation refresh token passed in userDTO
        // if refresh token also expired, pass "REFRESH_EXPIRED" so frontend know to logout
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getUsername(), userDto.getRoles()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/signOut")
    public ResponseEntity<Void> signOut() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }

}
