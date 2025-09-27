package br.com.techchallenge.schedule_management.infrastructure.consultation.repository;

import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.Consultation;
import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.ConsultationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Page<Consultation> findByDoctorId(Long doctorId, Pageable pageable);
    Page<Consultation> findByPatientId(Long patientId, Pageable pageable);

    @Query("SELECT c FROM Consultation c WHERE c.status in :finishedStatus")
    List<Consultation> getFinishedConsultations(List<ConsultationStatus> finishedStatus);
}
