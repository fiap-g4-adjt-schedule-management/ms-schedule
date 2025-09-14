package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.GetConsultationsCase;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetConsultationsCaseImpl implements GetConsultationsCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public PageResult<ConsultationDomain> run(Integer page, Integer size) {
        return consultationGateway.getConsultations(page, size);
    }

}
