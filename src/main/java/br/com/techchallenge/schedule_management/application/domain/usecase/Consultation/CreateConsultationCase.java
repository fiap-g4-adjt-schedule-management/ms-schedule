package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;

public interface CreateConsultationCase {

    ConsultationDomain run(CreateConsultationDTO createConsultationDTO);

}
