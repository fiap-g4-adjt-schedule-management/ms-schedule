package br.com.techchallenge.schedule_management.application.dto.Speciality;

import br.com.techchallenge.schedule_management.application.domain.entity.SpecialityDomain;
import br.com.techchallenge.schedule_management.infrastructure.speciality.entity.Speciality;

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

    public SpecialityDTO (Speciality speciality) {
        this(
                speciality.getId(),
                speciality.getName()
        );
    }

}
