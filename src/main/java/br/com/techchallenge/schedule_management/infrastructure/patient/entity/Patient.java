package br.com.techchallenge.schedule_management.infrastructure.patient.entity;

import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;
import br.com.techchallenge.schedule_management.infrastructure.authentication.entity.Credentials;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity(name = "Patient")
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    private Credentials credentials;

}
