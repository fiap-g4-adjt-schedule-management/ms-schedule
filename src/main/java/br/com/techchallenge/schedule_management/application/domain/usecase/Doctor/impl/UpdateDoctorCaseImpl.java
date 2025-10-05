package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.UpdateDoctorCase;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.exceptions.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDoctorCaseImpl implements UpdateDoctorCase {

    private final DoctorGateway doctorGateway;

    @Override
    public DoctorDomain run(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        doctorGateway.getDoctorById(doctorId).orElseThrow(
                () -> new NotFoundException("Doctor not found")
        );
        this.isDoctorValid(doctorId, updateDoctorDTO);

        return doctorGateway.updateDoctor(doctorId, updateDoctorDTO);
    }

    private void isDoctorValid(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        this.isEmailAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.email());
        this.isPhoneAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.phone());
        this.isCrmAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.crm());
        this.isCpfAlreadyExistsWithOtherDoctor(doctorId, updateDoctorDTO.cpf());
    }

    private void isEmailAlreadyExistsWithOtherDoctor(Long doctorId, String email) {
        if (doctorGateway.isEmailAlreadyExistsWithOtherDoctor(doctorId, email)) {
            throw new AlreadyExistsException("Email already exists");
        }
    }

    private void isPhoneAlreadyExistsWithOtherDoctor(Long doctorId, String phone) {
        if (doctorGateway.isPhoneAlreadyExistsWithOtherDoctor(doctorId, phone)) {
            throw new AlreadyExistsException("Phone already exists");
        }
    }

    private void isCrmAlreadyExistsWithOtherDoctor(Long doctorId, String crm) {
        if (doctorGateway.isCrmAlreadyExistsWithOtherDoctor(doctorId, crm)) {
            throw new AlreadyExistsException("CRM already exists");
        }
    }

    private void isCpfAlreadyExistsWithOtherDoctor(Long doctorId, String cpf) {
        if (doctorGateway.isCpfAlreadyExistsWithOtherDoctor(doctorId, cpf)) {
            throw new AlreadyExistsException("CPF already exists");
        }
    }

}
