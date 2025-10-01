package br.com.techchallenge.schedule_management.infrastructure.nurse.entity;

import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity(name = "Nurse")
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String coren;

    @Embedded
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
