package br.com.techchallenge.schedule_management.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ConsultationDomain {

    private DoctorDomain doctor;
    private PatientDomain patient;
    private LocalDateTime dateTime;

}
