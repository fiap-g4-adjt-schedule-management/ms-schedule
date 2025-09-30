package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.domain.entity.CredentialsDomain;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;

public interface CredentialsDataSource {

    CredentialsDomain getCredentials(CredentialsDTO credentialDTO);

}
