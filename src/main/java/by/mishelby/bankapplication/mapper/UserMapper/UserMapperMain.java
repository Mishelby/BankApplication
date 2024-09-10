package by.mishelby.bankapplication.mapper.UserMapper;

import by.mishelby.bankapplication.mapper.BankAccountMapper.BankAccountToDTOMapper;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserDTO;
import by.mishelby.bankapplication.model.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserMapperMain {
    private final BankAccountToDTOMapper bankAccountToDTOMapper;

    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        var userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthDate(user.getBirthDate());

        log.info("User bank accounts list: " + user.getBankAccounts());
        List<BankAccountDTO> bankAccounts = user.getBankAccounts()
                .stream()
                .map(bankAccountToDTOMapper::toDTO)
                .toList();

        userDTO.setBankAccounts(bankAccounts);

        return userDTO;
    }
}
