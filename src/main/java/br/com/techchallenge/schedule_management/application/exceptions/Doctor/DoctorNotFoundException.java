package br.com.techchallenge.schedule_management.application.exceptions.Doctor;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException (String message) {
        super(message);
    }

}
