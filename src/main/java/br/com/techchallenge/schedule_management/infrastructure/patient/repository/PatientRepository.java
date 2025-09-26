package br.com.techchallenge.schedule_management.infrastructure.patient.repository;

import br.com.techchallenge.schedule_management.infrastructure.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
