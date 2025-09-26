package br.com.techchallenge.schedule_management.infrastructure.doctor.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.impl.DoctorControllerImpl;
import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.doctor.controller.DoctorApiController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorApiControllerImpl implements DoctorApiController {

    private final DoctorDataSource doctorDataSource;

    @Override
    public PageResult<DoctorDTO> getDoctors(Integer page, Integer size) {
        var doctorController = new DoctorControllerImpl(doctorDataSource);

        return doctorController.getDoctors(page, size);
    }

    @Override
    public DoctorDTO getDoctorById(Long doctorId) {
        var doctorController = new DoctorControllerImpl(doctorDataSource);
        return doctorController.getDoctorById(doctorId);
    }

    @Override
    public DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO) {
        var doctorController = new DoctorControllerImpl(doctorDataSource);

        return doctorController.createDoctor(createDoctorDTO);
    }

    @Override
    public DoctorDTO updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        var doctorController = new DoctorControllerImpl(doctorDataSource);

        return doctorController.updateDoctor(doctorId, updateDoctorDTO);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        var doctorController = new DoctorControllerImpl(doctorDataSource);

        doctorController.deleteDoctorById(doctorId);
    }

}
