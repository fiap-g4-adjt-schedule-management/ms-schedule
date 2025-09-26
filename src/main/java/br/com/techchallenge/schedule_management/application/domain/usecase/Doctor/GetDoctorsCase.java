package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

public interface GetDoctorsCase {

    PageResult<DoctorDomain> run(Integer page, Integer size);

}
