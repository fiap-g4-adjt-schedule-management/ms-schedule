package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Doctor.DoctorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DoctorDomain {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private SpecialityDomain speciality;
    private String crm;
    private AddressDomain address;

    public DoctorDomain(DoctorDTO doctorDTO) {
        this.id = doctorDTO.id();
        this.name = doctorDTO.name();
        this.cpf = doctorDTO.cpf();
        this.phone = doctorDTO.phone();
        this.email = doctorDTO.email();
        this.crm = doctorDTO.crm();
        this.address = new AddressDomain(
                doctorDTO.address().zipCode(),
                doctorDTO.address().street(),
                doctorDTO.address().number(),
                doctorDTO.address().complement(),
                doctorDTO.address().neighborhood(),
                doctorDTO.address().city(),
                doctorDTO.address().state()
        );
    }

}
