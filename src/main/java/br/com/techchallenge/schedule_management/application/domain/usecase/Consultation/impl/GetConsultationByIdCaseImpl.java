package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.GetConsultationByIdCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetConsultationByIdCaseImpl implements GetConsultationByIdCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public ConsultationDomain run(Long consultationId) {
        return consultationGateway.getConsultationById(consultationId);
    }
}
