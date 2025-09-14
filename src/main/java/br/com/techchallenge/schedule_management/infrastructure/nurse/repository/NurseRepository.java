package br.com.techchallenge.schedule_management.infrastructure.nurse.repository;

import br.com.techchallenge.schedule_management.infrastructure.nurse.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
