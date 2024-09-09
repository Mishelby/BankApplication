package by.mishelby.bankapplication.model.user;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.UserUpdatedDTO;
import by.mishelby.bankapplication.utils.interfaces.ValidBirthDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    @JsonBackReference
    @ToString.Exclude
    private List<BankAccount> bankAccounts;

    public User(String firstName, String middleName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.bankAccounts = new ArrayList<>();
    }

    public class Updater {
        private final ModelMapper modelMapper = new ModelMapper();

        public boolean update(UserUpdatedDTO userUpdatedDTO) {
            if (userUpdatedDTO == null) {
                throw new IllegalArgumentException("userUpdatedDTO is null");
            }

            modelMapper.map(userUpdatedDTO, User.this);
            return true;
        }
    }

}