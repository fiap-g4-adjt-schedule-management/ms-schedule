package br.com.techchallenge.schedule_management.infrastructure.consultation.controller;


import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.UpdateConsultationStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface ConsultationApiController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    PageResult<ConsultationDTO> getConsultations(
            Integer page,
            Integer size
    );

    @GetMapping("/{consultationId}")
    @ResponseStatus(HttpStatus.OK)
    ConsultationDTO getConsultationById(
            @PathVariable
            Long consultationId
    );

    @GetMapping("/by-doctor/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    PageResult<ConsultationDTO> getConsultationsByDoctorId(
            @PathVariable
            Long doctorId,
            Integer page,
            Integer size
    );

    @GetMapping("/by-patient/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    PageResult<ConsultationDTO> getConsultationsByPatientId(
            @PathVariable
            Long patientId,
            Integer page,
            Integer size
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ConsultationDTO createConsultation(
            @RequestBody
            CreateConsultationDTO createConsultationDTO
    );

    @PutMapping("/{consultationId}")
    @ResponseStatus(HttpStatus.OK)
    ConsultationDTO updateConsultation(
            @PathVariable
            Long consultationId,
            @RequestBody
            UpdateConsultationDTO updateConsultationDTO
    );

    @PatchMapping("/update-status/{consultationId}")
    ConsultationDTO updateConsultationStatus(
            @PathVariable
            Long consultationId,
            @RequestBody
            UpdateConsultationStatusDTO updateConsultationStatusDTO
    );

    void sendFinishedConsultationsToHistory();

}
