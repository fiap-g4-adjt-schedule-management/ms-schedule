package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ConsultationDomain {

    private Long id;
    private DoctorDomain doctor;
    private PatientDomain patient;
    private LocalDateTime dateTime;
    private NurseDomain createdBy;
    private String reason;
    private LocalDateTime createdAt;

    public ConsultationDomain(ConsultationDTO consultationDTO) {
        this.id = consultationDTO.consultationId();
        this.doctor = new DoctorDomain(consultationDTO.doctor());
        this.patient = new PatientDomain(consultationDTO.patient());
        this.dateTime = consultationDTO.dateTime();
        this.createdBy = new NurseDomain(consultationDTO.nurse());
        this.reason = consultationDTO.reason();
        this.createdAt = consultationDTO.createdAt();
    }

}
