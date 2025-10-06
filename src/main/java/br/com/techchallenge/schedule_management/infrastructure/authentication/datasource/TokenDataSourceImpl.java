package br.com.techchallenge.schedule_management.infrastructure.authentication.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.TokenDataSource;
import br.com.techchallenge.schedule_management.application.dto.Authentication.TokenDTO;
import br.com.techchallenge.schedule_management.application.dto.Authentication.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class TokenDataSourceImpl implements TokenDataSource {

    private final JwtEncoder jwtEncoder;

    @Override
    public TokenDTO generateToken(UserDTO userDTO) {
        Instant now = Instant.now();
        long expire = 3600L;

        String scope = "";

        if (userDTO.userType().equals("NURSE")) {
            scope = "ROLE_NURSE";
        } else if (userDTO.userType().equals("PATIENT")) {
            scope = "ROLE_PATIENT";
        } else if (userDTO.userType().equals("DOCTOR")) {
            scope = "ROLE_DOCTOR";
        }

        var claims = JwtClaimsSet.builder()
                .issuer("ms-schedule")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expire))
                .subject(userDTO.name())
                .claim("userId",  userDTO.id())
                .claim("userType", userDTO.userType())
                .claim("scope", scope)
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new TokenDTO(
                "Bearer",
                token
        );
    }

}
