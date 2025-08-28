package br.com.techchallenge.schedule_management.infrastructure.speciality.repository;

import br.com.techchallenge.schedule_management.infrastructure.speciality.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
