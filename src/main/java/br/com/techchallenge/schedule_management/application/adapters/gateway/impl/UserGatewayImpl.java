package br.com.techchallenge.schedule_management.application.adapters.gateway.impl;

import br.com.techchallenge.schedule_management.application.adapters.datasource.TokenDataSource;
import br.com.techchallenge.schedule_management.application.adapters.datasource.UserDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.UserGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.UserDomain;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserDataSource userDataSource;
    private final TokenDataSource tokenDataSource;

    @Override
    public UserDomain getUserByCredentials(CredentialsDTO credentialDTO) {
        var userDTO = userDataSource.getUserByCredentials(credentialDTO);
        return new UserDomain(userDTO);
    }

    @Override
    public TokenDTO generateToken(UserDomain userDomain) {
        return tokenDataSource.generateToken(new UserDTO(userDomain));
    }

}
