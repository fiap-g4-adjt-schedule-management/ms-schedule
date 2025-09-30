package br.com.techchallenge.schedule_management.infrastructure.doctor.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.adapters.datasource.UserDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.UserType;
import br.com.techchallenge.schedule_management.infrastructure.doctor.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorDataSourceImpl implements DoctorDataSource, UserDataSource {

    private final DoctorRepository doctorRepository;

    @Override
    public Optional<UserDTO> getUserByCredentialsId(Long credentialsId) {
        var doctorOptional = doctorRepository.findByCredentialsId(credentialsId);

        if (doctorOptional.isEmpty()) {
            return Optional.empty();
        }
        var doctor = doctorOptional.get();

        return Optional.of(new UserDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                UserType.DOCTOR.name()
        ));
    }
}
