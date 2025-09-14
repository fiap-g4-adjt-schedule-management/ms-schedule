package br.com.techchallenge.schedule_management.application.adapters.controller;

import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

public interface ConsultationController {

    ConsultationDTO getConsultationById(Long consultationId);
    PageResult<ConsultationDTO> getConsultations(Integer page, Integer size);
    PageResult<ConsultationDTO> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size);
    PageResult<ConsultationDTO> getConsultationsByPatientId(Long patientId, Integer page, Integer size);
    ConsultationDTO createConsultation(CreateConsultationDTO createConsultationDTO);
    ConsultationDTO updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO);

}
