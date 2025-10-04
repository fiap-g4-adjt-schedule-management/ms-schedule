package br.com.techchallenge.schedule_management.infrastructure.authentication.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.CredentialsDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.CredentialsDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.FullCredentialsDTO;
import br.com.techchallenge.schedule_management.infrastructure.authentication.repository.CredentialsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CredentialsDataSourceImpl implements CredentialsDataSource {

    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public FullCredentialsDTO getCredentialsByEmail(String email) {
        var credentials = credentialsRepository.findByEmail(email);

        return new FullCredentialsDTO(
                credentials.getId(),
                credentials.getEmail(),
                credentials.getPassword(),
                credentials.getUserType().name()
        );
    }

    @Override
    public Boolean checkEncodedPassword(String originalPassword, String encodedPassword) {
        return passwordEncoder.matches(originalPassword, encodedPassword);
    }

}
