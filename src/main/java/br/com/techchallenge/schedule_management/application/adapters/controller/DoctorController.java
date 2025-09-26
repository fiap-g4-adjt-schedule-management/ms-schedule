package br.com.techchallenge.schedule_management.application.adapters.controller;

import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;

public interface DoctorController {

    PageResult<DoctorDTO> getDoctors(Integer page, Integer pageSize);
    DoctorDTO getDoctorById(Long doctorId);
    DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO);
    DoctorDTO updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO);
    void deleteDoctorById(Long doctorId);

}
