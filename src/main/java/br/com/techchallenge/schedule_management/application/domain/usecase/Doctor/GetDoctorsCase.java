package br.com.techchallenge.schedule_management.application.domain.usecase.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;

public interface GetDoctorsCase {

    PaginationDomain<DoctorDomain> run(Integer page, Integer size);

}
