package br.com.techchallenge.schedule_management.infrastructure.doctor.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.DoctorDataSource;
import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Speciality.SpecialityDTO;
import br.com.techchallenge.schedule_management.infrastructure.doctor.entity.Doctor;
import br.com.techchallenge.schedule_management.infrastructure.doctor.repository.DoctorRepository;
import br.com.techchallenge.schedule_management.infrastructure.speciality.repository.SpecialityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorDataSourceImpl implements DoctorDataSource {

    private final DoctorRepository doctorRepository;

    @Override
    public Page<DoctorDTO> findDoctors(Integer page, Integer size) {
        var pageable = this.createPageable(page, size);
        return doctorRepository.findAll(pageable).map(DoctorDTO::new);
    }

    @Override
    public Optional<DoctorDTO> findDoctorById(Long id) {
        var doctorOp = doctorRepository.findById(id);
        return doctorOp.map(DoctorDTO::new);
    }

    @Override
    public DoctorDTO createDoctor(CreateDoctorDTO createDoctorDTO) {
        var doctor = new Doctor(createDoctorDTO);

        doctorRepository.save(doctor);

        return new DoctorDTO(doctor);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, UpdateDoctorDTO updateDoctorDTO) {
        var doctorOp = doctorRepository.findById(id);

        if (doctorOp.isEmpty()) return null;

        var doctor = doctorOp.get();
        doctor.updateDoctor(updateDoctorDTO);

        doctorRepository.save(doctor);

        return new DoctorDTO(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<DoctorDTO> findDoctorByEmail(String email) {
        var doctorOp = doctorRepository.findByEmail(email);
        return doctorOp.map(DoctorDTO::new);
    }

    @Override
    public Optional<DoctorDTO> findDoctorByCrm(String crm) {
        var doctorOp = doctorRepository.findByCrm(crm);
        return doctorOp.map(DoctorDTO::new);
    }

    @Override
    public Optional<DoctorDTO> findDoctorByCpf(String cpf) {
        var doctorOp = doctorRepository.findByCpf(cpf);
        return doctorOp.map(DoctorDTO::new);
    }

    @Override
    public Optional<DoctorDTO> findDoctorByPhone(String phone) {
        var doctorOp = doctorRepository.findByPhone(phone);
        return doctorOp.map(DoctorDTO::new);
    }

    private Pageable createPageable(Integer page, Integer size) {
        return PageRequest.of(page, size);
    }

}
