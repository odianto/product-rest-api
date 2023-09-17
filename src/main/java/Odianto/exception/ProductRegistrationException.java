package Odianto.exception;


public class ProductRegistrationException extends RuntimeException {
    public ProductRegistrationException(String message) {
        super(message);
    }

    public ProductRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}