package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Patient.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PatientDomain {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private AddressDomain address;

    public PatientDomain(PatientDTO patient) {
        this.id = patient.id();
        this.name = patient.name();
        this.cpf = patient.cpf();
        this.email = patient.email();
        this.phone = patient.phone();
        this.address = new AddressDomain(patient.address());
    }
}
