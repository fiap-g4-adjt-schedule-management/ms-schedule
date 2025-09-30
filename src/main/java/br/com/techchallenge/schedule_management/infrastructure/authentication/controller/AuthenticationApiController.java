package br.com.techchallenge.schedule_management.infrastructure.authentication.controller;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationApiController {

    @PostMapping
    ResponseEntity<TokenDTO> authenticate(

            @RequestBody
            CredentialsDTO credentialsDTO

    );

}
