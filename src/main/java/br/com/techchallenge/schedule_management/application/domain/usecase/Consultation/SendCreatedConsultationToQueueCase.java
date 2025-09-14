package br.com.techchallenge.schedule_management.application.domain.usecase.Consultation;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;

public interface SendCreatedConsultationToQueueCase {

    void run(ConsultationDomain consultationDomain);

}
