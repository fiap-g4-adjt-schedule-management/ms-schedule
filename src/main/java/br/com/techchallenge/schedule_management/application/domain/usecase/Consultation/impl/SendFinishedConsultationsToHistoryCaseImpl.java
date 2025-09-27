package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.SendFinishedConsultationsToHistoryCase;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.SendNotificationToQueueCase;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class SendFinishedConsultationsToHistoryCaseImpl implements SendFinishedConsultationsToHistoryCase {

    private final ConsultationGateway consultationGateway;
    private final Logger logger = LoggerFactory.getLogger(SendFinishedConsultationsToHistoryCaseImpl.class);

    @Override
    public void run() {
        var finishedConsultations = consultationGateway.getFinishedConsultations();

        for (var finishedConsultation : finishedConsultations) {
            this.logger.info("Enviando a consulta ao histórico: " + finishedConsultation.toString());
            consultationGateway.sendFinishedConsultationToHistory(finishedConsultation);
        }
    }

}
