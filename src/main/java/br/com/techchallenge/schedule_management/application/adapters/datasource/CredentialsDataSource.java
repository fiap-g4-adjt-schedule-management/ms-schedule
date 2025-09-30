package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;

public interface CredentialsDataSource {

    FullCredentialsDTO getCredentials(CredentialsDTO credentialDTO);

}
