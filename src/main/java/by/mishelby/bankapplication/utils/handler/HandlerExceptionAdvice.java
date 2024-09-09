package by.mishelby.bankapplication.utils.handler;

import by.mishelby.bankapplication.service.exceptions.ResourceNotFoundException;
import by.mishelby.bankapplication.service.exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public final class HandlerExceptionAdvice {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(final UserException e) {
        var errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorValidationResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        var bindingResult = ex.getBindingResult();
        var errorMessage = getErrorResponse(bindingResult).getMessage();

        return new ErrorValidationResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(final ResourceNotFoundException e) {
        var errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exception(final Exception e) {
        var errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public static ErrorValidationResponse getErrorResponse(BindingResult bindingResult) {
        var errorMessage = new StringBuilder("Validation failed: ");

        bindingResult.getFieldErrors().forEach(error -> {
            errorMessage.append("Field '").append(error.getField()).append("' - ")
                    .append(error.getDefaultMessage()).append("; ");
        });

        return new ErrorValidationResponse(HttpStatus.BAD_REQUEST.value(), errorMessage.toString());
    }

}
