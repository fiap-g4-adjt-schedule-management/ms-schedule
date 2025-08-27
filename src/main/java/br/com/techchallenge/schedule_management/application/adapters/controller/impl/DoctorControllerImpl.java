package br.com.techchallenge.schedule_management.application.adapters.controller.impl;

import br.com.techchallenge.schedule_management.application.adapters.controller.DoctorController;
import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.adapters.gateway.impl.DoctorGatewayImpl;
import br.com.techchallenge.schedule_management.application.domain.entity.PaginationDomain;
import br.com.techchallenge.schedule_management.application.domain.usecase.Doctor.impl.*;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoctorControllerImpl implements DoctorController {

    private final DoctorDataSource doctorDataSource;

    @Override
    public PaginationDomain<DoctorDTO> getDoctors(Integer page, Integer pageSize) {
        var doctorGateway = new DoctorGatewayImpl(doctorDataSource);
        var getDoctorsCase = new GetDoctorsCaseImpl(doctorGateway);

        var doctorsPage = getDoctorsCase.run(page, pageSize);

        return new PaginationDomain<>(
                doctorsPage.getItems().stream().map(DoctorDTO::new).toList(),
                doctorsPage.getPage(),
                doctorsPage.getSize(),
                doctorsPage.getTotalItems()
        );
    }

    @Override
    public DoctorDTO getDoctorById(Long doctorId) {
        var doctorGateway = new DoctorGatewayImpl(doctorDataSource);
        var getDoctorByIdCase = new GetDoctorByIdCaseImpl(doctorGateway);

        var doctorDomain = getDoctorByIdCase.run(doctorId);

        return new DoctorDTO(doctorDomain);
    }

    @Override
    public DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO) {
        var doctorGateway = new DoctorGatewayImpl(doctorDataSource);
        var createDoctorCase = new CreateDoctorCaseImpl(doctorGateway);

        var doctorDomain = createDoctorCase.run(createDoctorDTO);

        return new DoctorDTO(doctorDomain);
    }

    @Override
    public DoctorDTO updateDoctor(Long doctorId, UpdateDoctorDTO updateDoctorDTO) {
        var doctorGateway = new DoctorGatewayImpl(doctorDataSource);
        var updateDoctorCase = new UpdateDoctorCaseImpl(doctorGateway);

        var doctorDomain = updateDoctorCase.run(doctorId, updateDoctorDTO);

        return new DoctorDTO(doctorDomain);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        var doctorGateway = new DoctorGatewayImpl(doctorDataSource);
        var deleteDoctorByIdCase = new DeleteDoctorByIdCaseImpl(doctorGateway);

        deleteDoctorByIdCase.run(doctorId);
    }

}
