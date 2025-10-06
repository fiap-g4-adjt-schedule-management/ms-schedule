package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.CredentialsGateway;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.CheckEncodedPasswordCase;
import br.com.techchallenge.schedule_management.application.exceptions.authentication.InvalidCredentials;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckEncodedPasswordCaseImpl implements CheckEncodedPasswordCase {

    private final CredentialsGateway credentialsGateway;

    @Override
    public void run(String originalPassword, String encodedPassword) {
        var isPasswordCorrect = credentialsGateway.checkEncodedPassword(originalPassword, encodedPassword);

        if (!isPasswordCorrect) {
            throw new InvalidCredentials("Invalid credentials");
        }
    }

}
