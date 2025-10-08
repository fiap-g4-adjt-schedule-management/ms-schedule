package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;

public interface UpdateConsultationCase {

    ConsultationDomain run(Long consultationId, UpdateConsultationDTO updateConsultationDTO);

}
