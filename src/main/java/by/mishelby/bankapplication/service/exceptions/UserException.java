package by.mishelby.bankapplication.service.exceptions;

public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message) {
        super(message);
    }
}
