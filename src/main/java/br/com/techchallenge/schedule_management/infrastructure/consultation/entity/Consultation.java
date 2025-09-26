package br.com.techchallenge.schedule_management.infrastructure.consultation.entity;

import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.infrastructure.doctor.entity.Doctor;
import br.com.techchallenge.schedule_management.infrastructure.nurse.entity.Nurse;
import br.com.techchallenge.schedule_management.infrastructure.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "consultation")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Nurse nurse;

    private LocalDateTime consultationDate;
    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Consultation(
            CreateConsultationDTO createConsultationDTO,
            Patient patient,
            Doctor doctor,
            Nurse nurse
    ) {
        this.patient = patient;
        this.doctor = doctor;
        this.nurse = nurse;
        this.consultationDate = createConsultationDTO.dateTime();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateConsultation(
            UpdateConsultationDTO updateConsultationDTO,
            Patient patient,
            Doctor doctor,
            Nurse nurse
    ) {
        this.patient = patient;
        this.doctor = doctor;
        this.nurse = nurse;
        this.consultationDate = updateConsultationDTO.dateTime();
        this.updatedAt = LocalDateTime.now();
    }
}
