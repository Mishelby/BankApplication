package by.mishelby.bankapplication.model.dto.UserDTO;

import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.utils.interfaces.ValidBirthDate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class UserDTO {
    @NotNull(message = "Id should not be null")
    private Long id;

    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotNull(message = "Middle name cannot be null")
    @NotEmpty(message = "Middle name cannot be empty")
    private String middleName;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Past(message = "Birth date must be in the past")
    @ValidBirthDate
    private LocalDate birthDate;

    private List<BankAccountDTO> bankAccounts;
}
