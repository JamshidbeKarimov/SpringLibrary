package uz.pdp.springdatajpa.exception;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
