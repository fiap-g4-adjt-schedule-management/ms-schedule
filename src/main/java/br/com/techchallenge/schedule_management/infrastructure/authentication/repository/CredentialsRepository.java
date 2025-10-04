package br.com.techchallenge.schedule_management.infrastructure.authentication.repository;

import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Credentials findByEmail(String email);

}
