package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.UpdateConsultationCase;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateConsultationCaseImpl implements UpdateConsultationCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public ConsultationDomain run(Long consultationId, UpdateConsultationDTO updateConsultationDTO) {
        return consultationGateway.updateConsultation(consultationId, updateConsultationDTO);
    }

}
