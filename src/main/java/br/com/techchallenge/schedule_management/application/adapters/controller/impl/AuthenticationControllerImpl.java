package br.com.techchallenge.schedule_management.application.adapters.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.AuthenticationController;
import br.com.techchallenge.schedule_management.application.adapters.datasource.*;
import br.com.techchallenge.schedule_management.application.adapters.gateway.UserGateway;
import br.com.techchallenge.schedule_management.application.adapters.gateway.impl.CredentialsGatewayImpl;
import br.com.techchallenge.schedule_management.application.adapters.gateway.impl.UserGatewayImpl;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl.AuthenticateCaseImpl;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl.CheckEncodedPasswordCaseImpl;
import br.com.techchallenge.schedule_management.application.domain.usecase.Authentication.impl.GetCredentialsCaseImpl;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final UserDataSource doctorDataSource;
    private final UserDataSource nurseDataSource;
    private final UserDataSource patientDataSource;
    private final TokenDataSource tokenDataSource;
    private final CredentialsDataSource credentialsDataSource;

    @Override
    public TokenDTO authenticate(CredentialsDTO credentialDTO) {
        var credentialsGateway = new CredentialsGatewayImpl(credentialsDataSource);

        var getCredentialsCase = new GetCredentialsCaseImpl(credentialsGateway);
        var credentials = getCredentialsCase.run(credentialDTO.email());

        var checkEncodedPasswordCase = new CheckEncodedPasswordCaseImpl(credentialsGateway);
        checkEncodedPasswordCase.run(credentialDTO.password(), credentials.password());

        UserGateway userGateway;

        if (credentials.userType().equals("DOCTOR")) {
            userGateway = new UserGatewayImpl(doctorDataSource, tokenDataSource);
        } else if (credentials.userType().equals("PATIENT")) {
            userGateway = new UserGatewayImpl(patientDataSource, tokenDataSource);
        } else {
            userGateway = new UserGatewayImpl(nurseDataSource, tokenDataSource);
        }

        var authenticateCase = new AuthenticateCaseImpl(userGateway);

        return authenticateCase.run(credentials.id());
    }

}
