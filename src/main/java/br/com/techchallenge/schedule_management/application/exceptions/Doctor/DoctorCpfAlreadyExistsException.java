package br.com.techchallenge.schedule_management.application.exceptions.Doctor;

public class DoctorCpfAlreadyExistsException extends RuntimeException {

    public DoctorCpfAlreadyExistsException(String message) {
        super(message);
    }

}
