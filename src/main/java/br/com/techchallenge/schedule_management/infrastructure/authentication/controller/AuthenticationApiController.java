package br.com.techchallenge.schedule_management.infrastructure.authentication.controller;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.dto.UserDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationApiController {

    @PostMapping
    ResponseEntity<TokenDTO> authenticate(
            @RequestBody
            CredentialsDTO credentialsDTO
    );

    @GetMapping("/token-validator")
    ResponseEntity<UserDataDTO> validateToken(
            @AuthenticationPrincipal
            Jwt jwt
    );

}
