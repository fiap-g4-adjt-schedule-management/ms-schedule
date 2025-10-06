package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication;

import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;

public interface AuthenticateCase {

    TokenDTO run(Long credentialsId);

}
