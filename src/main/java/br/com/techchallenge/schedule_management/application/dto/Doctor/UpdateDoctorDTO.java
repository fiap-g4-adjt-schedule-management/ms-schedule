package br.com.techchallenge.schedule_management.application.dto.Doctor;

import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;

public record UpdateDoctorDTO(
        String name,
        String cpf,
        String phone,
        String email,
        Long specialityId,
        String crm,
        AddressDTO address
) { }
