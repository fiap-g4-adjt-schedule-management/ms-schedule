package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;

public interface CredentialsGateway {

    FullCredentialsDTO getCredentialsByEmailAndPassword(CredentialsDTO credentialsDTO);

}
