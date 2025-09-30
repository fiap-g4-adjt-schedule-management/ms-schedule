package br.com.techchallenge.schedule_management.infrastructure.doctor.entity;

import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;
import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.Credentials;
import br.com.techchallenge.schedule_management.infrastructure.speciality.entity.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "Doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String crm;

    @Embedded
    private Address address;
    @ManyToOne(fetch = FetchType.EAGER)
    private Speciality speciality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    private Credentials credentials;

}
