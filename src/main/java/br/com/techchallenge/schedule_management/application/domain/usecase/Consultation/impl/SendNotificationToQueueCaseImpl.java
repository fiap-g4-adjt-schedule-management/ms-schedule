package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.SendNotificationToQueueCase;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendNotificationToQueueCaseImpl implements SendNotificationToQueueCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public void run(NotificationDTO notificationDTO) {
        consultationGateway.sendNotificationToQueue(notificationDTO);
    }

}
