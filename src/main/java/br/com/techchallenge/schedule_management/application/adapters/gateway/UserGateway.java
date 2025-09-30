package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.domain.entity.UserDomain;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;

public interface UserGateway {

    UserDomain getUserByCredentialsId(Long credentialsId);
    TokenDTO  generateToken(UserDomain userDomain);

}
