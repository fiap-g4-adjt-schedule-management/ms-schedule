package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.UserGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.UserTypeDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.AuthenticateCase;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticateCaseImpl implements AuthenticateCase {

    private final UserGateway userGateway;

    @Override
    public TokenDTO run(Long credentialsId) {
        var user = userGateway.getUserByCredentialsId(credentialsId);

        return userGateway.generateToken(user);
    }
}
