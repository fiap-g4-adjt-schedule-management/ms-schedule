package br.com.techchallenge.schedule_management.application.domain.entity;

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

}
