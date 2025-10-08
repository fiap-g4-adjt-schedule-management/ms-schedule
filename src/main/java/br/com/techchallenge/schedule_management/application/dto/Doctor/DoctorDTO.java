package br.com.techchallenge.schedule_management.application.dto.Doctor;

import br.com.techchallenge.schedule_management.application.domain.entity.DoctorDomain;
import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;
import br.com.techchallenge.schedule_management.application.dto.Speciality.SpecialityDTO;
import br.com.techchallenge.schedule_management.infrastructure.doctor.entity.Doctor;

public record DoctorDTO (

        Long id,
        String name,
        String cpf,
        String email,
        String phone,
        SpecialityDTO speciality,
        String crm,
        AddressDTO address

) {

    public DoctorDTO(DoctorDomain doctorDomain) {
        this(
                doctorDomain.getId(),
                doctorDomain.getName(),
                doctorDomain.getCpf(),
                doctorDomain.getEmail(),
                doctorDomain.getPhone(),
                new SpecialityDTO(doctorDomain.getSpeciality()),
                doctorDomain.getCrm(),
                new AddressDTO(doctorDomain.getAddress())
        );
    }

    public DoctorDTO(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getCpf(),
                doctor.getEmail(),
                doctor.getPhone(),
                new SpecialityDTO(doctor.getSpeciality()),
                doctor.getCrm(),
                new AddressDTO(doctor.getAddress())
        );
    }

}
