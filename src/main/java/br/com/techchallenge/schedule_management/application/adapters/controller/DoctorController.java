package br.com.techchallenge.schedule_management.application.adapters.controller;

import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;

public interface DoctorController {

    PaginationDomain<DoctorDTO> getDoctors(Integer page, Integer pageSize);
    DoctorDTO getDoctorById(Long doctorId);
    DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorDTO updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO);
    void deleteDoctorById(Long doctorId);

}
