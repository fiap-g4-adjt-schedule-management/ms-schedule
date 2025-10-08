package br.com.techchallenge.schedule_management.application.dto.Authentication;

import br.com.techchallenge.schedule_management.application.domain.entity.UserDomain;

public record UserDTO(
        Long id,
        String name,
        String email,
        String userType
) {
    public UserDTO(UserDomain userDomain) {
        this(
                userDomain.getId(),
                userDomain.getName(),
                userDomain.getEmail(),
                userDomain.getUserType().name()
        );
    }
}
