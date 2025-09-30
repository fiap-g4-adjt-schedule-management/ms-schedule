package br.com.techchallenge.schedule_management.infrastructure.authentication.controller.impl;

import br.com.techchallenge.schedule_management.infrastructure.authentication.controller.AuthenticationApiController;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationApiControllerImpl implements AuthenticationApiController {

    @Override
    public ResponseEntity<TokenDTO> authenticate(CredentialsDTO credentialsDTO) {
        return ResponseEntity.ok(new TokenDTO("Bearer", "Hello World"));
    }

}
