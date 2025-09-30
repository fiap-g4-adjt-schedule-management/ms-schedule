package br.com.techchallenge.schedule_management.infrastructure.authentication.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.CredentialsDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.repository.CredentialsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CredentialsDataSourceImpl implements CredentialsDataSource {

    private final CredentialsRepository credentialsRepository;

    @Override
    public FullCredentialsDTO getCredentials(CredentialsDTO credentialDTO) {
        var credentials = credentialsRepository.findByEmailAndPassword(
                credentialDTO.email(),
                credentialDTO.password()
        );

        return new FullCredentialsDTO(
                credentials.getId(),
                credentials.getEmail(),
                credentials.getPassword(),
                credentials.getUserType().name()
        );
    }

}
