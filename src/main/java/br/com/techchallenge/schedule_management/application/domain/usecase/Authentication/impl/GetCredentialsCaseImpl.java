package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.CredentialsGateway;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.GetCredentialsCase;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCredentialsCaseImpl implements GetCredentialsCase {

    private final CredentialsGateway credentialsGateway;

    @Override
    public FullCredentialsDTO run(String email) {
        return credentialsGateway.getCredentialsByEmail(email);
    }

}
