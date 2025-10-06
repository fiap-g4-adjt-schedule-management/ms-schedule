package br.com.techchallenge.schedule_management.infrastructure.patient.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.PatientDataSource;
import br.com.techchallenge.schedule_management.application.adapters.datasource.UserDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.UserType;
import br.com.techchallenge.schedule_management.infrastructure.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PatientDataSourceImpl implements PatientDataSource, UserDataSource {

    private final PatientRepository patientRepository;

    @Override
    public Optional<UserDTO> getUserByCredentialsId(Long credentialsId) {
        var patientOptional = patientRepository.findByCredentialsId(credentialsId);

        if (patientOptional.isEmpty()) {
            return Optional.empty();
        }

        var patient = patientOptional.get();
        return Optional.of(new UserDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                UserType.PATIENT.name()
        ));
    }

}
