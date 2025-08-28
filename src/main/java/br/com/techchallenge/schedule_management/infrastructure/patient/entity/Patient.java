package br.com.techchallenge.schedule_management.infrastructure.patient.entity;

import br.com.techchallenge.schedule_management.application.domain.entity.AddressDomain;
import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;

    @Embedded
    private Address address;

}
