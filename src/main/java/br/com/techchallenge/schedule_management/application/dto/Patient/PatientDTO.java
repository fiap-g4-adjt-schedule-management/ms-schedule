package br.com.techchallenge.schedule_management.application.dto.Patient;

import br.com.techchallenge.schedule_management.application.domain.entity.PatientDomain;
import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;
import br.com.techchallenge.schedule_management.infrastructure.patient.entity.Patient;

public record PatientDTO(

        Long id,
        String name,
        String cpf,
        String email,
        String phone,
        AddressDTO address

) {
    public PatientDTO(PatientDomain patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getCpf(),
                patient.getEmail(),
                patient.getPhone(),
                new AddressDTO(patient.getAddress())
        );
    }

    public PatientDTO(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getCpf(),
                patient.getEmail(),
                patient.getPhone(),
                new AddressDTO(patient.getAddress())
        );
    }
}
