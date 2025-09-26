package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.GetConsultationByPatientIdCase;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetConsultationByPatientIdCaseImpl implements GetConsultationByPatientIdCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public PageResult<ConsultationDomain> run(Long patientId, Integer page, Integer size) {
        return consultationGateway.getConsultationsByPatientId(patientId, page, size);
    }

}
