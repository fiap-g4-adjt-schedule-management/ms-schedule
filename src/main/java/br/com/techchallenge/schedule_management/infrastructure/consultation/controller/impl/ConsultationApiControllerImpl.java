package br.com.techchallenge.schedule_management.infrastructure.consultation.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.impl.ConsultationControllerImpl;
import br.com.techchallenge.schedule_management.application.adapters.datasource.ConsultationDataSource;
import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.controller.ConsultationApiController;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.UpdateConsultationStatusDTO;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
@AllArgsConstructor
public class ConsultationApiControllerImpl implements ConsultationApiController {

    private final ConsultationDataSource consultationDataSource;

    @Override
    public PageResult<ConsultationDTO> getConsultations(Integer page, Integer size) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.getConsultations(page, size);
    }

    @Override
    public ConsultationDTO getConsultationById(Long consultationId) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.getConsultationById(consultationId);
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.getConsultationsByDoctorId(doctorId, page, size);
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByPatientId(Long patientId, Integer page, Integer size) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.getConsultationsByPatientId(patientId, page, size);
    }

    @Override
    public ConsultationDTO createConsultation(CreateConsultationDTO createConsultationDTO) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.createConsultation(createConsultationDTO);
    }

    @Override
    public ConsultationDTO updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.updateConsultation(consultationId, updateConsultationDTO);
    }

    @Override
    public ConsultationDTO updateConsultationStatus(Long consultationId, UpdateConsultationStatusDTO updateConsultationStatusDTO) {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        return consultationController.updateConsultationStatus(consultationId, updateConsultationStatusDTO.status());
    }

    @Override
    @Scheduled(cron = "0 */1 * * * *")
    public void sendFinishedConsultationsToHistory() {
        var consultationController = new ConsultationControllerImpl(consultationDataSource);

        consultationController.sendFinishedConsultationsToHistory();
    }

}
