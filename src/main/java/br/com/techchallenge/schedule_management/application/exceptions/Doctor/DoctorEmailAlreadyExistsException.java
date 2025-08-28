package br.com.techchallenge.schedule_management.application.exceptions.Doctor;

public class DoctorEmailAlreadyExistsException extends RuntimeException {

    public DoctorEmailAlreadyExistsException(String message) {
        super(message);
    }

}
