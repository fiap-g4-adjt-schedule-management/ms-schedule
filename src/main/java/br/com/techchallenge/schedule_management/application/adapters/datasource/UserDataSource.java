package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;

public interface UserDataSource {

    UserDTO getUserByCredentials(CredentialsDTO credentialDTO);

}
