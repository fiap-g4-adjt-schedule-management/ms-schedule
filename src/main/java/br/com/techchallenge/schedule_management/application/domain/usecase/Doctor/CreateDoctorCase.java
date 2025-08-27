package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;

public interface CreateDoctorCase {

    DoctorDomain run(CreateDoctorDTO createDoctorDTO);

}
