package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationStatusDomain;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;

import java.util.List;

public interface ConsultationGateway {

    ConsultationDomain createConsultation(CreateConsultationDTO createConsultationDTO);
    ConsultationDomain updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO);
    ConsultationDomain updateConsultationStatus(Long id, ConsultationStatusDomain status);
    ConsultationDomain getConsultationById(Long consultationId);
    PageResult<ConsultationDomain> getConsultations(Integer page, Integer size);
    PageResult<ConsultationDomain> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size);
    PageResult<ConsultationDomain> getConsultationsByPatientId(Long patientId, Integer page, Integer size);
    List<ConsultationDomain> getFinishedConsultations();
    void sendNotificationToQueue(NotificationDTO notificationDTO);
    void sendFinishedConsultationToHistory(ConsultationDomain finishedConsultation);
}
