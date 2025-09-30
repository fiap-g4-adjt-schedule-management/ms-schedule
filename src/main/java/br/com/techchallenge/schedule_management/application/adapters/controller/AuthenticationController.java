package br.com.techchallenge.schedule_management.application.adapters.controller;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;

public interface AuthenticationController {

    TokenDTO authenticate(CredentialsDTO credentialDTO);

}
