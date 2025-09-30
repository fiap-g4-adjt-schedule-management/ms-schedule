package br.com.techchallenge.schedule_management.infrastructure.authentication.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.impl.AuthenticationControllerImpl;
import br.com.techchallenge.schedule_management.application.adapters.datasource.*;
import br.com.techchallenge.schedule_management.infrastructure.authentication.controller.AuthenticationApiController;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import br.com.techchallenge.schedule_management.infrastructure.doctor.datasource.DoctorDataSourceImpl;
import br.com.techchallenge.schedule_management.infrastructure.doctor.repository.DoctorRepository;
import br.com.techchallenge.schedule_management.infrastructure.nurse.datasource.NurseDataSourceImpl;
import br.com.techchallenge.schedule_management.infrastructure.nurse.repository.NurseRepository;
import br.com.techchallenge.schedule_management.infrastructure.patient.datasource.PatientDataSourceImpl;
import br.com.techchallenge.schedule_management.infrastructure.patient.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationApiControllerImpl implements AuthenticationApiController {

    private final TokenDataSource tokenDataSource;
    private final UserDataSource doctorDataSource;
    private final UserDataSource nurseDataSource;
    private final UserDataSource patientDataSource;
    private final CredentialsDataSource credentialsDataSource;

    public AuthenticationApiControllerImpl(
            TokenDataSource tokenDataSource,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository,
            NurseRepository nurseRepository,
            CredentialsDataSource credentialsDataSource
    ) {
        this.tokenDataSource = tokenDataSource;
        this.credentialsDataSource = credentialsDataSource;
        this.doctorDataSource = new DoctorDataSourceImpl(doctorRepository);
        this.nurseDataSource = new NurseDataSourceImpl(nurseRepository);
        this.patientDataSource = new PatientDataSourceImpl(patientRepository);
    }

    @Override
    public ResponseEntity<TokenDTO> authenticate(CredentialsDTO credentialsDTO) {
        var authenticationController = new AuthenticationControllerImpl(
                doctorDataSource,
                nurseDataSource,
                patientDataSource,
                tokenDataSource,
                credentialsDataSource
        );

        var tokenDTO = authenticationController.authenticate(credentialsDTO);

        return ResponseEntity.ok(tokenDTO);
    }

}
