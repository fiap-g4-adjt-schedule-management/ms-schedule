package br.com.techchallenge.schedule_management.application.adapters.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.AuthenticationController;
import br.com.techchallenge.schedule_management.application.adapters.datasource.TokenDataSource;
import br.com.techchallenge.schedule_management.application.adapters.datasource.UserDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final UserDataSource userDataSource;
    private final TokenDataSource tokenDataSource;

    @Override
    public TokenDTO authenticate(CredentialsDTO credentialDTO) {
        return null;
    }

}
