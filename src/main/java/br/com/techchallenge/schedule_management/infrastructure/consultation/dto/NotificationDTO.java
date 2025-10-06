package br.com.techchallenge.schedule_management.infrastructure.consultation.dto;

import java.time.LocalDateTime;

public record NotificationDTO(
        String title,
        String pacientName,
        String clientEmail,
        String clientPhone,
        String doctorName,
        LocalDateTime date,
        String type
) {}