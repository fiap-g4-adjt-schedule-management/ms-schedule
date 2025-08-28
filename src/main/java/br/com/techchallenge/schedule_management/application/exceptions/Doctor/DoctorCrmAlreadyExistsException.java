package br.com.techchallenge.schedule_management.application.exceptions.Doctor;

public class DoctorCrmAlreadyExistsException extends RuntimeException {

    public DoctorCrmAlreadyExistsException(String message) {
        super(message);
    }

}
