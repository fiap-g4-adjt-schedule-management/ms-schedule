package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl;

import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.GetDoctorByIdCase;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.GetDoctorsCase;
import br.com.techchallenge.schedule_management.application.exceptions.Doctor.DoctorNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetDoctorsCaseImpl implements GetDoctorsCase {

    private final DoctorGateway doctorGateway;

    @Override
    public PaginationDomain<DoctorDomain> run(Integer page, Integer size) {
        return doctorGateway.getDoctors(page, size);
    }

}
