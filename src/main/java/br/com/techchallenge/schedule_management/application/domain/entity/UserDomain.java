package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDomain {

    private Long id;
    private String name;
    private String email;
    private UserTypeDomain userType;

    public UserDomain(UserDTO userDTO) {
        this(
                userDTO.id(),
                userDTO.name(),
                userDTO.email(),
                UserTypeDomain.valueOf(userDTO.userType())
        );
    }

}
