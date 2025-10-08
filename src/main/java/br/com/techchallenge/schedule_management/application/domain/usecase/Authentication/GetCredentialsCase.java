package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication;

import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;

public interface GetCredentialsCase {

    FullCredentialsDTO run(String email);

}
