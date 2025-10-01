package br.com.techchallenge.schedule_management.application.adapters.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.ConsultationController;
import br.com.techchallenge.schedule_management.application.adapters.datasource.ConsultationDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.impl.ConsultationGatewayImpl;
import br.com.techchallenge.schedule_management.application.domain.usecase.Consultation.impl.*;
import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsultationControllerImpl implements ConsultationController {

    private final ConsultationDataSource consultationDataSource;

    @Override
    public ConsultationDTO getConsultationById(Long consultationId) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var getConsultationByIdCase = new GetConsultationByIdCaseImpl(consultationGateway);

        var consultationDomain = getConsultationByIdCase.run(consultationId);

        return new ConsultationDTO(consultationDomain);
    }

    @Override
    public PageResult<ConsultationDTO> getConsultations(Integer page, Integer size) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var getConsultationsCase = new GetConsultationsCaseImpl(consultationGateway);

        var consultationsDomainPage = getConsultationsCase.run(page, size);

        return new PageResult<>(
                consultationsDomainPage.getItems().stream().map(ConsultationDTO::new).toList(),
                consultationsDomainPage.getPage(),
                consultationsDomainPage.getSize(),
                consultationsDomainPage.getTotalItems()
        );
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var getConsultationsByDoctorIdCase = new GetConsultationByDoctorIdCaseImpl(consultationGateway);

        var consultationsDomainPage = getConsultationsByDoctorIdCase.run(doctorId, page, size);

        return new PageResult<>(
                consultationsDomainPage.getItems().stream().map(ConsultationDTO::new).toList(),
                consultationsDomainPage.getPage(),
                consultationsDomainPage.getSize(),
                consultationsDomainPage.getTotalItems()
        );
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByPatientId(Long patientId, Integer page, Integer size) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var getConsultationsByPatientIdCase = new GetConsultationByPatientIdCaseImpl(consultationGateway);

        var consultationsDomainPage = getConsultationsByPatientIdCase.run(patientId, page, size);

        return new PageResult<>(
                consultationsDomainPage.getItems().stream().map(ConsultationDTO::new).toList(),
                consultationsDomainPage.getPage(),
                consultationsDomainPage.getSize(),
                consultationsDomainPage.getTotalItems()
        );
    }

    @Override
    public ConsultationDTO createConsultation(CreateConsultationDTO createConsultationDTO) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var createConsultationCase = new CreateConsultationCaseImpl(consultationGateway);

        var createdConsultation = createConsultationCase.run(createConsultationDTO);

        var sendNotificationToQueueCase = new SendNotificationToQueueCaseImpl(consultationGateway);

        sendNotificationToQueueCase.run(new NotificationDTO(
                "Sua consulta foi marcada!",
                "Sua consulta foi marcada para o dia " + createdConsultation.getDateTime() + " gostaria de confirmar sua presença?",
                createdConsultation.getPatient().getEmail(),
                createdConsultation.getPatient().getPhone()
        ));

        return new ConsultationDTO(createdConsultation);
    }

    @Override
    public ConsultationDTO updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var updateConsultationCase = new UpdateConsultationCaseImpl(consultationGateway);

        var updatedConsultation = updateConsultationCase.run(consultationId, updateConsultationDTO);

        var sendNotificationToQueue = new SendNotificationToQueueCaseImpl(consultationGateway);

        sendNotificationToQueue.run(new NotificationDTO(
                "Sua consulta foi atualizada!",
                "Sua consulta foi atualizada para o dia " + updatedConsultation.getDateTime() + " gostaria de confirmar sua presença?",
                updatedConsultation.getPatient().getEmail(),
                updatedConsultation.getPatient().getPhone()
        ));

        return new ConsultationDTO(updatedConsultation);
    }

    @Override
    public ConsultationDTO updateConsultationStatus(Long consultationId, String status) {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var updateConsultationStatusCase = new UpdateConsultationStatusCaseImpl(consultationGateway);

        var updatedConsultation = updateConsultationStatusCase.run(consultationId, status);

        var sendNotificationToQueueCase = new  SendNotificationToQueueCaseImpl(consultationGateway);

        sendNotificationToQueueCase.run(new NotificationDTO(
                "A situação da sua consulta foi alterada!",
                "Sua consulta foi " + status + "!",
                updatedConsultation.getPatient().getEmail(),
                updatedConsultation.getPatient().getPhone()
        ));

        return new ConsultationDTO(updatedConsultation);
    }

    @Override
    public void sendFinishedConsultationsToHistory() {
        var consultationGateway = new ConsultationGatewayImpl(consultationDataSource);
        var sendFinishedConsultationsToHistoryCase = new SendFinishedConsultationsToHistoryCaseImpl(consultationGateway);

        sendFinishedConsultationsToHistoryCase.run();
    }

}
