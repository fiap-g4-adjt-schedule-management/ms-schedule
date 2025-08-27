package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.CreateDoctorCase;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.UpdateDoctorCase;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.exceptions.Doctor.DoctorNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDoctorCaseImpl implements UpdateDoctorCase {

    private final DoctorGateway doctorGateway;

    @Override
    public DoctorDomain run(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        doctorGateway.getDoctorById(doctorId).orElseThrow(
                () -> new DoctorNotFoundException("Doctor not found")
        );
        this.isDoctorValid(doctorId, updateDoctorDTO);

        return doctorGateway.updateDoctor(doctorId, updateDoctorDTO);
    }

    private void isDoctorValid(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        doctorGateway.isEmailAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.email());
        doctorGateway.isPhoneAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.phone());
        doctorGateway.isCrmAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.crm());
        doctorGateway.isCpfAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.cpf());
    }
}
