package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;

public interface SendFinishedConsultationsToHistoryCase {

    void run();

}
