package br.com.techchallenge.schedule_management.infrastructure.consultation.dto;

public record NotificationDTO(
        String title,
        String message,
        String clientEmail,
        String clientPhone
) {}
