package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;

public interface GetDoctorByIdCase {

    DoctorDomain run(Long doctorId);

}
