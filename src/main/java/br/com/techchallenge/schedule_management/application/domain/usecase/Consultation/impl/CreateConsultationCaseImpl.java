package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.CreateConsultationCase;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateConsultationCaseImpl implements CreateConsultationCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public ConsultationDomain run(CreateConsultationDTO createConsultationDTO) {
        return consultationGateway.createConsultation(createConsultationDTO);
    }

}
