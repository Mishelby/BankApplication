package by.mishelby.bankapplication.service.exceptions;

public class BankAccountException extends RuntimeException {
    public BankAccountException() {
    }

    public BankAccountException(Throwable cause) {
        super(cause);
    }

    public BankAccountException(String message) {
        super(message);
    }
}
