package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;

import java.util.Optional;

public interface UserDataSource {

    Optional<UserDTO> getUserByCredentialsId(Long credentialsId);

}
