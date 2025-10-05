package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.GetConsultationByIdCase;
import br.com.techchallenge.schedule_management.application.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetConsultationByIdCaseImpl implements GetConsultationByIdCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public ConsultationDomain run(Long consultationId) {
        var consultation = consultationGateway.getConsultationById(consultationId);

        if (consultation == null) {
            throw new NotFoundException("Consultation not found");
        }

        return consultation;
    }
}
