package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.SendFinishedConsultationsToHistoryCase;
import lombok.AllArgsConstructor;

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
            this.logger.info("Consulta enviada com sucesso!");
            this.logger.info("Removendo da base de dados principal.");
            consultationGateway.deleteConsultationById(finishedConsultation.getId());
            this.logger.info("Removido com sucesso!");
        }
    }

}
