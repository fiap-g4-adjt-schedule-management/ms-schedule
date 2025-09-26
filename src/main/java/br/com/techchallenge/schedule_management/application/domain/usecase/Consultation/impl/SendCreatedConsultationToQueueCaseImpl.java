package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.SendCreatedConsultationToQueueCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendCreatedConsultationToQueueCaseImpl implements SendCreatedConsultationToQueueCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public void run(ConsultationDomain consultationDomain) {
        consultationGateway.sendCreatedConsultationToQueue(consultationDomain);
    }

}
