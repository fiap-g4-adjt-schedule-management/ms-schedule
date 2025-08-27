package br.com.techchallenge.schedule_management.application.dto.Doctor;

import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;

public record CreateDoctorDTO(

        String name,
        String cpf,
        String phone,
        String email,
        Long specialityId,
        String crm,
        AddressDTO address

) { }
