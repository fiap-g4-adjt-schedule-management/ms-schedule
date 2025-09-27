package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationStatusDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.UpdateConsultationStatusCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateConsultationStatusCaseImpl implements UpdateConsultationStatusCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public ConsultationDomain run(Long consultationId, String status) {
        return consultationGateway.updateConsultationStatus(
                consultationId,
                ConsultationStatusDomain.valueOf(status)
        );
    }

}
