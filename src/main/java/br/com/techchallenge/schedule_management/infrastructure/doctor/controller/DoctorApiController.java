package br.com.techchallenge.schedule_management.infrastructure.doctor.controller;

import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface DoctorApiController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    PaginationDomain<DoctorDTO> getDoctors(
            @RequestParam
            Integer page,
            @RequestParam
            Integer size
    );

    @GetMapping("/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    DoctorDTO getDoctorById(
            @PathVariable
            Long doctorId
    );

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DoctorDTO createDoctor(
            @RequestBody
            CreateDoctorDTO createDoctorDTO
    );

    @PutMapping("/{doctorId}")
    @ResponseStatus(HttpStatus.CREATED)
    DoctorDTO updateDoctor(
            @PathVariable
            Long doctorId,
            @RequestBody
            UpdateDoctorDTO updateDoctorDTO
    );

    @DeleteMapping("/{doctorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDoctor(
            @PathVariable
            Long doctorId
    );

}
