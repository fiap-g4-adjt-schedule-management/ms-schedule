package br.com.techchallenge.schedule_management.infrastructure.consultation.repository;

import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Page<Consultation> findByDoctorId(Long doctorId, Pageable pageable);
    Page<Consultation> findByPatientId(Long patientId, Pageable pageable);

}
