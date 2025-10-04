package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;

public interface CredentialsGateway {

    FullCredentialsDTO getCredentialsByEmail(String email);
    Boolean checkEncodedPassword(String originalPassword, String encodedPassword);

}
