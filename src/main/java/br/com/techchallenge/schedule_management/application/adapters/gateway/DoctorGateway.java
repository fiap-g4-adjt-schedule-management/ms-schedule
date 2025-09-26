package br.com.techchallenge.schedule_management.application.adapters.gateway;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

import java.util.Optional;

public interface DoctorGateway {

    PageResult<DoctorDomain> getDoctors(Integer page, Integer size);
    Optional<DoctorDomain> getDoctorById(Long doctorId);
    DoctorDomain createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorDomain updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO);
    void deleteDoctorById(Long doctorId);
    boolean isEmailAlreadyExists(String email);
    boolean isPhoneAlreadyExists(String phone);
    boolean isCpfAlreadyExists(String cpf);
    boolean isCrmAlreadyExists(String crm);
    boolean isEmailAlreadyExistsWithOtherDoctor(Long doctorId, String email);
    boolean isPhoneAlreadyExistsWithOtherDoctor(Long doctorId, String phone);
    boolean isCpfAlreadyExistsWithOtherDoctor(Long doctorId, String cpf);
    boolean isCrmAlreadyExistsWithOtherDoctor(Long doctorId, String crm);

}
