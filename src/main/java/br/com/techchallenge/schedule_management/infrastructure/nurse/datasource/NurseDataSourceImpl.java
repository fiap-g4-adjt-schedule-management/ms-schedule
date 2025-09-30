package br.com.techchallenge.schedule_management.infrastructure.nurse.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.NurseDataSource;
import br.com.techchallenge.schedule_management.application.adapters.datasource.UserDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.UserType;
import br.com.techchallenge.schedule_management.infrastructure.nurse.repository.NurseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class NurseDataSourceImpl implements NurseDataSource, UserDataSource {

    private final NurseRepository nurseRepository;

    @Override
    public Optional<UserDTO> getUserByCredentialsId(Long credentialsId) {
        var nurseOptional = nurseRepository.findByCredentialsId(credentialsId);

        if (nurseOptional.isEmpty()) {
            return Optional.empty();
        }

        var nurse = nurseOptional.get();
        return Optional.of(new UserDTO(
                nurse.getId(),
                nurse.getName(),
                nurse.getEmail(),
                UserType.NURSE.name()
        ));
    }

}
