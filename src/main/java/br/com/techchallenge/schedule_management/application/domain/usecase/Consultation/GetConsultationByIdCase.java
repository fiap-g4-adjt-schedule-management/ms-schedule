package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;

public interface GetConsultationByIdCase {

    ConsultationDomain run(Long consultationId);

}
