package br.com.techchallenge.schedule_management.application.dto.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Nurse.NurseDTO;
import br.com.techchallenge.schedule_management.application.dto.Patient.PatientDTO;
import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.Consultation;

import java.time.LocalDateTime;

public record ConsultationDTO(

        Long consultationId,
        DoctorDTO doctor,
        PatientDTO patient,
        NurseDTO nurse,
        String reason,
        LocalDateTime createdAt,
        LocalDateTime dateTime,
        String observation,
        String status

) {
    public ConsultationDTO(ConsultationDomain consultationDomain) {
        this(
                consultationDomain.getId(),
                new DoctorDTO(consultationDomain.getDoctor()),
                new PatientDTO(consultationDomain.getPatient()),
                new NurseDTO(consultationDomain.getCreatedBy()),
                consultationDomain.getReason(),
                consultationDomain.getCreatedAt(),
                consultationDomain.getDateTime(),
                consultationDomain.getObservation(),
                consultationDomain.getStatus().name()
        );
    }

    public ConsultationDTO(Consultation createdConsultation) {
        this(
                createdConsultation.getId(),
                new DoctorDTO(createdConsultation.getDoctor()),
                new PatientDTO(createdConsultation.getPatient()),
                new NurseDTO(createdConsultation.getNurse()),
                createdConsultation.getReason(),
                createdConsultation.getCreatedAt(),
                createdConsultation.getConsultationDate(),
                createdConsultation.getObservation(),
                createdConsultation.getStatus().name()
        );
    }
}
