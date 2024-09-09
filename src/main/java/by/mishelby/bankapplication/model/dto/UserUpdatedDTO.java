package by.mishelby.bankapplication.model.dto;

import by.mishelby.bankapplication.utils.interfaces.ValidBirthDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdatedDTO {
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Middle name cannot be null")
    private String middleName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @Past(message = "Birth date must be in the past")
    @ValidBirthDate
    private LocalDate birthDate;
}
