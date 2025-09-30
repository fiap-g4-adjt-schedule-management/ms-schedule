package br.com.techchallenge.schedule_management.infrastructure.doctor.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.infrastructure.doctor.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorDataSourceImpl implements DoctorDataSource {

    private final DoctorRepository doctorRepository;

}
