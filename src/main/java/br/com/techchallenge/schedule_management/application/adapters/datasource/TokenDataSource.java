package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;

public interface TokenDataSource {

    TokenDTO generateToken(UserDTO userDTO);

}
