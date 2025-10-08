package br.com.techchallenge.schedule_management.application.dto.Authentication;

public record TokenDTO(
        String type,
        String token
) {
}
