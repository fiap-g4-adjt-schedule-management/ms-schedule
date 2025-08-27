package br.com.techchallenge.schedule_management.application.dto.Speciality;

import br.com.techchallenge.schedule_management.application.domain.entity.SpecialityDomain;

public record SpecialityDTO(

        Long id,
        String name

) {
    public SpecialityDTO (SpecialityDomain specialityDomain) {
        this(
                specialityDomain.getId(),
                specialityDomain.getName()
        );
    }
}
