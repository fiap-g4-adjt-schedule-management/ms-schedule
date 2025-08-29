package br.com.techchallenge.schedule_management.application.domain.entity;

import br.com.techchallenge.schedule_management.application.dto.Speciality.SpecialityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpecialityDomain {

    private Long id;
    private String name;

    public SpecialityDomain(SpecialityDTO speciality) {
        this(
                speciality.id(),
                speciality.name()
        );
    }
}
