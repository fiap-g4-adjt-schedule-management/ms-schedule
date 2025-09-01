package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;

public interface UpdateDoctorCase {

    DoctorDomain run(Long doctorId, UpdateDoctorDTO updateDoctorDTO);

}
