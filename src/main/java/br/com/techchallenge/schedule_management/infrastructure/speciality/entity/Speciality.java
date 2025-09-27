package br.com.techchallenge.schedule_management.infrastructure.speciality.entity;

import br.com.techchallenge.schedule_management.infrastructure.doctor.entity.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Speciality")
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<Doctor> doctors;

    public Speciality(Long id) {
        this.id = id;
    }

}
