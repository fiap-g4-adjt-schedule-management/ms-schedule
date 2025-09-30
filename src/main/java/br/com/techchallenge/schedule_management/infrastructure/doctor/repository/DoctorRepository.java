package br.com.techchallenge.schedule_management.infrastructure.doctor.repository;

import br.com.techchallenge.schedule_management.infrastructure.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByPhone(String phone);
    Optional<Doctor> findByCpf(String cpf);
    Optional<Doctor> findByCrm(String crm);
    Optional<Doctor> findByCredentialsId(Long credentialsId);

}
