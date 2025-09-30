package br.com.techchallenge.schedule_management.application.adapters.gateway.impl;

import br.com.techchallenge.schedule_management.application.adapters.datasource.CredentialsDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.CredentialsGateway;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CredentialsGatewayImpl implements CredentialsGateway {

    private final CredentialsDataSource credentialsDataSource;

    @Override
    public FullCredentialsDTO getCredentialsByEmailAndPassword(CredentialsDTO credentialsDTO) {
        return credentialsDataSource.getCredentials(credentialsDTO);
    }

}
