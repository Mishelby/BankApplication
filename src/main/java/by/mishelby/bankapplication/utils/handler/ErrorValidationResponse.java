package by.mishelby.bankapplication.utils.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorValidationResponse {
    private int status;
    private String message;
}
