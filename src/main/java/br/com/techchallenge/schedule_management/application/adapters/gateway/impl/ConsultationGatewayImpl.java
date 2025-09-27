package br.com.techchallenge.schedule_management.application.adapters.gateway.impl;

import br.com.techchallenge.schedule_management.application.adapters.datasource.ConsultationDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.ConsultationGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.ConsultationStatusDomain;
import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ConsultationGatewayImpl implements ConsultationGateway {

    private final ConsultationDataSource consultationDataSource;

    @Override
    public ConsultationDomain createConsultation(CreateConsultationDTO createConsultationDTO) {
        var createdConsultation = consultationDataSource.createConsultation(createConsultationDTO);

        return new ConsultationDomain(createdConsultation);
    }

    @Override
    public ConsultationDomain updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO) {
        var updatedConsultation = consultationDataSource.updateConsultation(consultationId, updateConsultationDTO);

        return new ConsultationDomain(updatedConsultation);
    }

    @Override
    public ConsultationDomain updateConsultationStatus(Long id, ConsultationStatusDomain status) {
        var updatedConsultation = consultationDataSource.updateConsultationStatus(id, status.name());

        return new ConsultationDomain(updatedConsultation);
    }

    @Override
    public ConsultationDomain getConsultationById(Long consultationId) {
        var consultationDTOOp = consultationDataSource.getConsultationById(consultationId);

        return consultationDTOOp.map(ConsultationDomain::new).orElse(null);

    }

    @Override
    public PageResult<ConsultationDomain> getConsultations(Integer page, Integer size) {
        var consultationsPage = consultationDataSource.getConsultations(page, size);

        return new PageResult<>(
                consultationsPage.getItems().stream().map(ConsultationDomain::new).toList(),
                page,
                size,
                consultationsPage.getTotalItems()
        );
    }

    @Override
    public PageResult<ConsultationDomain> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size) {
        var consultationsPage = consultationDataSource.getConsultationsByDoctorId(doctorId, page, size);

        return new PageResult<>(
                consultationsPage.getItems().stream().map(ConsultationDomain::new).toList(),
                page,
                size,
                consultationsPage.getTotalItems()
        );
    }

    @Override
    public PageResult<ConsultationDomain> getConsultationsByPatientId(Long patientId, Integer page, Integer size) {
        var consultationsPage = consultationDataSource.getConsultationsByPatientId(patientId, page, size);

        return new PageResult<>(
                consultationsPage.getItems().stream().map(ConsultationDomain::new).toList(),
                page,
                size,
                consultationsPage.getTotalItems()
        );
    }

    @Override
    public List<ConsultationDomain> getFinishedConsultations() {
        var finishedConsultations = this.consultationDataSource.getFinishedConsultations();

        return finishedConsultations.stream().map(ConsultationDomain::new).toList();
    }

    @Override
    public void sendNotificationToQueue(NotificationDTO notificationDTO) {
        consultationDataSource.sendNotificationToQueue(notificationDTO);
    }

    @Override
    public void sendFinishedConsultationToHistory(ConsultationDomain finishedConsultation) {
        consultationDataSource.sendFinishedConsultationToQueue(new ConsultationDTO(finishedConsultation));
    }

}
