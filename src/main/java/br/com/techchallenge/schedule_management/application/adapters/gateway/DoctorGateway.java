package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;

import java.util.Optional;

public interface DoctorGateway {

    PaginationDomain<DoctorDomain> getDoctors(Integer page, Integer size);
    Optional<DoctorDomain> getDoctorById(Long doctorId);
    DoctorDomain createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorDomain updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO);
    void deleteDoctorById(Long doctorId);
    void isEmailAlreadyExists(String email);
    void isPhoneAlreadyExists(String phone);
    void isCpfAlreadyExists(String cpf);
    void isCrmAlreadyExists(String crm);
    void isEmailAlreadyExistsWithOtherDoctor(Long doctorId, String email);
    void isPhoneAlreadyExistsWithOtherDoctor(Long doctorId, String phone);
    void isCpfAlreadyExistsWithOtherDoctor(Long doctorId, String cpf);
    void isCrmAlreadyExistsWithOtherDoctor(Long doctorId, String crm);

}
