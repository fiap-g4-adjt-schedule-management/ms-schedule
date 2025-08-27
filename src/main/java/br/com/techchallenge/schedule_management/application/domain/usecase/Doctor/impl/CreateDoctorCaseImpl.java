package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.CreateDoctorCase;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
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
        doctorGateway.isEmailAlreadyExists(createDoctorDTO.email());
        doctorGateway.isPhoneAlreadyExists(createDoctorDTO.phone());
        doctorGateway.isCrmAlreadyExists(createDoctorDTO.crm());
        doctorGateway.isCpfAlreadyExists(createDoctorDTO.cpf());
    }

}
