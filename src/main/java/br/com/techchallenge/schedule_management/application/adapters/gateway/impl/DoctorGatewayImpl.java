package br.com.techchallenge.schedule_management.application.adapters.gateway.impl;

import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DoctorGatewayImpl implements DoctorGateway {

    private final DoctorDataSource doctorDataSource;

    @Override
    public PaginationDomain<DoctorDomain> getDoctors(Integer page, Integer size) {
        return null;
    }

    @Override
    public Optional<DoctorDomain> getDoctorById(Long doctorId) {
        return Optional.empty();
    }

    @Override
    public DoctorDomain createDoctor(CreateDoctorDTO createDoctorDTO) {
        return null;
    }

    @Override
    public DoctorDomain updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long doctorId) {

    }

    @Override
    public void isEmailAlreadyExists(String email) {

    }

    @Override
    public void isPhoneAlreadyExists(String phone) {

    }

    @Override
    public void isCpfAlreadyExists(String cpf) {

    }

    @Override
    public void isCrmAlreadyExists(String crm) {

    }

    @Override
    public void isEmailAlreadyExistsWithOtherDoctor(Long doctorId, String email) {

    }

    @Override
    public void isPhoneAlreadyExistsWithOtherDoctor(Long doctorId, String phone) {

    }

    @Override
    public void isCpfAlreadyExistsWithOtherDoctor(Long doctorId, String cpf) {

    }

    @Override
    public void isCrmAlreadyExistsWithOtherDoctor(Long doctorId, String crm) {

    }

}
