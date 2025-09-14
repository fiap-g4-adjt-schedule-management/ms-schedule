package br.com.techchallenge.schedule_management.application.adapters.gateway.impl;

import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.DoctorGateway;
import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DoctorGatewayImpl implements DoctorGateway {

    private final DoctorDataSource doctorDataSource;

    @Override
    public PageResult<DoctorDomain> getDoctors(Integer page, Integer size) {
        return null;
    }

    @Override
    public Optional<DoctorDomain> getDoctorById(Long doctorId) {
        var doctorOp = doctorDataSource.findDoctorById(doctorId);

        return doctorOp.map(DoctorDomain::new);
    }

    @Override
    public DoctorDomain createDoctor(CreateDoctorDTO createDoctorDTO) {
        var createdDoctor = doctorDataSource.createDoctor(createDoctorDTO);
        return new DoctorDomain(createdDoctor);
    }

    @Override
    public DoctorDomain updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        var updatedDoctor = doctorDataSource.updateDoctor(doctorId, updateDoctorDTO);
        return new DoctorDomain(updatedDoctor);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        doctorDataSource.deleteDoctorById(doctorId);
    }

    @Override
    public boolean isEmailAlreadyExists(String email) {
        var doctor = doctorDataSource.findDoctorByEmail(email);
        return doctor.isPresent();
    }

    @Override
    public boolean isPhoneAlreadyExists(String phone) {
        var doctor = doctorDataSource.findDoctorByPhone(phone);
        return doctor.isPresent();
    }

    @Override
    public boolean isCpfAlreadyExists(String cpf) {
        var doctor = doctorDataSource.findDoctorByCpf(cpf);
        return doctor.isPresent();
    }

    @Override
    public boolean isCrmAlreadyExists(String crm) {
        var doctor = doctorDataSource.findDoctorByCrm(crm);
        return doctor.isPresent();
    }

    @Override
    public boolean isEmailAlreadyExistsWithOtherDoctor(Long doctorId, String email) {
        var doctor = doctorDataSource.findDoctorByEmail(email);

        var isThisDoctorsEmail = doctor
                .map(doctorDTO -> doctorDTO.id().equals(doctorId))
                .orElse(false);

        return !isThisDoctorsEmail;
    }

    @Override
    public boolean isPhoneAlreadyExistsWithOtherDoctor(Long doctorId, String phone) {
        var doctor = doctorDataSource.findDoctorByPhone(phone);

        var isThisDoctorsPhone = doctor
                .map(doctorDTO -> doctorDTO.id().equals(doctorId))
                .orElse(false);

        return !isThisDoctorsPhone;
    }

    @Override
    public boolean isCpfAlreadyExistsWithOtherDoctor(Long doctorId, String cpf) {
        var doctor = doctorDataSource.findDoctorByCpf(cpf);

        var isThisDoctorsCpf = doctor
                .map(doctorDTO -> doctorDTO.id().equals(doctorId))
                .orElse(false);

        return !isThisDoctorsCpf;
    }

    @Override
    public boolean isCrmAlreadyExistsWithOtherDoctor(Long doctorId, String crm) {
        var doctor = doctorDataSource.findDoctorByCrm(crm);

        var isThisDoctorsCrm = doctor
                .map(doctorDTO -> doctorDTO.id().equals(doctorId))
                .orElse(false);

        return !isThisDoctorsCrm;
    }

}
