package br.com.techchallenge.schedule_management.application.dto.Consultation;

import java.time.LocalDateTime;

public record UpdateConsultationDTO(

        Long nurseId,
        Long doctorId,
        Long patientId,
        LocalDateTime dateTime,
        String reason,
        String observation

) {}
