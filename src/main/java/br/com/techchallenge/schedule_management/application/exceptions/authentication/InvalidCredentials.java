package br.com.techchallenge.schedule_management.application.exceptions.authentication;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String message) {
        super(message);
    }

}
