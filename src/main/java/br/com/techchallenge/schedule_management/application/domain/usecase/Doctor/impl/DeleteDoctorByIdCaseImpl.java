package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.CreateDoctorCase;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.DeleteDoctorByIdCase;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.exceptions.Doctor.DoctorNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteDoctorByIdCaseImpl implements DeleteDoctorByIdCase {

    private final DoctorGateway doctorGateway;

    @Override
    public void run(Long doctorId) {
        doctorGateway.getDoctorById(doctorId).orElseThrow(
                () -> new DoctorNotFoundException("Doctor not found")
        );

        doctorGateway.deleteDoctorById(doctorId);
    }
}
