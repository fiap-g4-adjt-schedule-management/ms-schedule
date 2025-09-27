package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;

import java.util.Optional;

public interface ConsultationDataSource {

    ConsultationDTO createConsultation(CreateConsultationDTO createConsultationDTO);
    ConsultationDTO updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO);
    ConsultationDTO updateConsultationStatus(Long consultationId, String status);
    Optional<ConsultationDTO> getConsultationById(Long consultationId);
    PageResult<ConsultationDTO> getConsultations(Integer page, Integer size);
    PageResult<ConsultationDTO> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size);
    PageResult<ConsultationDTO> getConsultationsByPatientId(Long patientId, Integer page, Integer size);
    void sendFinishedConsultationToQueue(ConsultationDTO consultationDTO);
    void sendNotificationToQueue(NotificationDTO notificationDTO);

}
