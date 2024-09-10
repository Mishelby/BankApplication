package by.mishelby.bankapplication.model.user;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    @ToString.Exclude
    private List<BankAccount> bankAccounts;

    public User(String firstName, String middleName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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