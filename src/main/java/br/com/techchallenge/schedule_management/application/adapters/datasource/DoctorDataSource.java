package br.com.techchallenge.schedule_management.application.adapters.datasource;

import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface DoctorDataSource {

    PaginationDomain<DoctorDTO> findDoctors(Integer page, Integer size);
    Optional<DoctorDTO> findDoctorById(Long id);
    DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorDTO updateDoctor(Long id, UpdateDoctorDTO updateDoctorDTO);
    void deleteDoctorById(Long id);
    Optional<DoctorDTO> findDoctorByEmail(String email);
    Optional<DoctorDTO> findDoctorByCrm(String crm);
    Optional<DoctorDTO> findDoctorByCpf(String cpf);
    Optional<DoctorDTO> findDoctorByPhone(String phone);

}
