package br.com.techchallenge.schedule_management.application.domain.usecase.Authentication;

public interface CheckEncodedPasswordCase {

    void run(String originalPassword, String encodedPassword);

}
