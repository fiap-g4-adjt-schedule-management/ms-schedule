package br.com.techchallenge.schedule_management.application.dto.Authentication;

public record FullCredentialsDTO(
        Long id,
        String email,
        String password,
        String userType
) {
}
