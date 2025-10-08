package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.GetConsultationByDoctorIdCase;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.application.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetConsultationByDoctorIdCaseImpl implements GetConsultationByDoctorIdCase {

    private final ConsultationGateway consultationGateway;

    @Override
    public PageResult<ConsultationDomain> run(Long doctorId, Integer page, Integer size) {
        var consultationList = consultationGateway.getConsultationsByDoctorId(doctorId, page, size);

        if (consultationList == null) {
            throw new NotFoundException("Consultation not found for doctor id: " + doctorId);
        }

        return consultationList;
    }

}
