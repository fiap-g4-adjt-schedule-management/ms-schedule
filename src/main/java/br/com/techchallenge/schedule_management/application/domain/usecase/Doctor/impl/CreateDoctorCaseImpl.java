package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.CreateDoctorCase;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.exceptions.AlreadyExistsException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateDoctorCaseImpl implements CreateDoctorCase {

    private final DoctorGateway doctorGateway;

    @Override
    public DoctorDomain run(CreateDoctorDTO createDoctorDTO) {
        this.isDoctorValid(createDoctorDTO);

        return doctorGateway.createDoctor(createDoctorDTO);
    }

    private void isDoctorValid(CreateDoctorDTO createDoctorDTO) {
        this.isEmailAlreadyExists(createDoctorDTO.email());
        this.isPhoneAlreadyExists(createDoctorDTO.phone());
        this.isCrmAlreadyExists(createDoctorDTO.crm());
        this.isCpfAlreadyExists(createDoctorDTO.cpf());
    }

    private void isEmailAlreadyExists(String email) {
        if (doctorGateway.isEmailAlreadyExists(email)) {
            throw new AlreadyExistsException("Email already exists");
        }
    }

    private void isPhoneAlreadyExists(String phone) {
        if (doctorGateway.isPhoneAlreadyExists(phone)) {
            throw new AlreadyExistsException("Phone already exists");
        }
    }

    private void isCpfAlreadyExists(String cpf) {
        if (doctorGateway.isCpfAlreadyExists(cpf)) {
            throw new AlreadyExistsException("CPF already exists");
        }
    }

    private void isCrmAlreadyExists(String crm) {
        if (doctorGateway.isCrmAlreadyExists(crm)) {
            throw new AlreadyExistsException("CRM already exists");
        }
    }

}
