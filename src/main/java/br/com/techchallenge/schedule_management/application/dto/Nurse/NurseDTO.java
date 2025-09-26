package br.com.techchallenge.schedule_management.application.dto.Nurse;

import br.com.techchallenge.schedule_management.application.domain.entity.NurseDomain;
import br.com.techchallenge.schedule_management.application.dto.Address.AddressDTO;
import br.com.techchallenge.schedule_management.infrastructure.nurse.entity.Nurse;

public record NurseDTO(
        Long id,
        String name,
        String cpf,
        String phone,
        String email,
        String coren,
        AddressDTO address
) {
    public NurseDTO(NurseDomain nurseDomain) {
        this(
                nurseDomain.getId(),
                nurseDomain.getName(),
                nurseDomain.getCpf(),
                nurseDomain.getPhone(),
                nurseDomain.getEmail(),
                nurseDomain.getCoren(),
                new AddressDTO(nurseDomain.getAddress())
        );
    }

    public NurseDTO(Nurse nurse) {
        this(
                nurse.getId(),
                nurse.getName(),
                nurse.getCpf(),
                nurse.getPhone(),
                nurse.getEmail(),
                nurse.getCoren(),
                new AddressDTO(nurse.getAddress())
        );
    }
}
