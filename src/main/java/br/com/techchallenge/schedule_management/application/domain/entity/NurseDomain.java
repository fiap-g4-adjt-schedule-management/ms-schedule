package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Nurse.NurseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NurseDomain {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String coren;
    private AddressDomain address;

    public NurseDomain(NurseDTO nurse) {
        this.id = nurse.id();
        this.name = nurse.name();
        this.cpf = nurse.cpf();
        this.phone = nurse.phone();
        this.email = nurse.email();
        this.coren = nurse.coren();
        this.address = new AddressDomain(nurse.address());
    }
}
