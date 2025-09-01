package br.com.techchallenge.schedule_management.application.exceptions.Doctor;

public class DoctorPhoneAlreadyExistsException extends RuntimeException {

    public DoctorPhoneAlreadyExistsException(String message) {
        super(message);
    }

}
