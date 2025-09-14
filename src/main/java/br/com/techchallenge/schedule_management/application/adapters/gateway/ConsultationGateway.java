package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

public interface ConsultationGateway {

    ConsultationDomain createConsultation(CreateConsultationDTO createConsultationDTO);
    ConsultationDomain updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO);
    ConsultationDomain getConsultationById(Long consultationId);
    PageResult<ConsultationDomain> getConsultations(Integer page, Integer size);
    PageResult<ConsultationDomain> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size);
    PageResult<ConsultationDomain> getConsultationsByPatientId(Long patientId, Integer page, Integer size);
    void sendCreatedConsultationToQueue(ConsultationDomain consultationDomain);

}
