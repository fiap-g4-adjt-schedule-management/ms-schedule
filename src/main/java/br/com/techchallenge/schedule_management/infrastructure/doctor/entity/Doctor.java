package br.com.techchallenge.schedule_management.infrastructure.doctor.entity;

import br.com.techchallenge.schedule_management.application.domain.entity.AddressDomain;
import br.com.techchallenge.schedule_management.application.domain.entity.SpecialityDomain;
import br.com.techchallenge.schedule_management.application.dto.Doctor.CreateDoctorDTO;
import br.com.techchallenge.schedule_management.application.dto.Doctor.UpdateDoctorDTO;
import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;
import br.com.techchallenge.schedule_management.infrastructure.speciality.entity.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String crm;

    @Embedded
    private Address address;
    @ManyToOne(fetch = FetchType.EAGER)
    private Speciality speciality;

    public Doctor (CreateDoctorDTO createDoctorDTO) {
        this(
                null,
                createDoctorDTO.name(),
                createDoctorDTO.cpf(),
                createDoctorDTO.phone(),
                createDoctorDTO.email(),
                createDoctorDTO.crm(),
                new Address(createDoctorDTO.address()),
                new Speciality(createDoctorDTO.specialityId())
        );
    }

    public void updateDoctor(UpdateDoctorDTO updateDoctorDTO) {
        this.name = updateDoctorDTO.name();
        this.cpf = updateDoctorDTO.cpf();
        this.phone = updateDoctorDTO.phone();
        this.email = updateDoctorDTO.email();
        this.crm = updateDoctorDTO.crm();
        this.address.updateAddress(updateDoctorDTO.address());
        this.speciality = new Speciality(updateDoctorDTO.specialityId());
    }
}
