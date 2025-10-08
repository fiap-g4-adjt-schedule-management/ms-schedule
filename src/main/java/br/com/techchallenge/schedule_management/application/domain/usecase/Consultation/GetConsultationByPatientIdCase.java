package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

public interface GetConsultationByPatientIdCase {

    PageResult<ConsultationDomain> run(Long patientId, Integer page, Integer size);

}
