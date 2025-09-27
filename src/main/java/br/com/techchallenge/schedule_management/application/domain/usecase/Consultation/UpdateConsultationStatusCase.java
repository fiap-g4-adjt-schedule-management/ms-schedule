package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;

public interface UpdateConsultationStatusCase {

    ConsultationDomain run(Long consultationId, String status);

}
