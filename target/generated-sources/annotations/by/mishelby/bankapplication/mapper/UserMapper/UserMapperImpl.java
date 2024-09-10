package by.mishelby.bankapplication.mapper.UserMapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.model.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T00:15:07+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserCreateDTO userCreateDTO) {
        if ( userCreateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userCreateDTO.getFirstName() );
        user.setMiddleName( userCreateDTO.getMiddleName() );
        user.setLastName( userCreateDTO.getLastName() );
        user.setBirthDate( userCreateDTO.getBirthDate() );

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setMiddleName( user.getMiddleName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setBirthDate( user.getBirthDate() );
        userDTO.setBankAccounts( bankAccountListToBankAccountDTOList( user.getBankAccounts() ) );

        return userDTO;
    }

    @Override
    public User userUpdateToUser(UserUpdatedDTO userUpdatedDTO) {
        if ( userUpdatedDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userUpdatedDTO.getFirstName() );
        user.setMiddleName( userUpdatedDTO.getMiddleName() );
        user.setLastName( userUpdatedDTO.getLastName() );
        user.setBirthDate( userUpdatedDTO.getBirthDate() );

        return user;
    }

    protected BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setBalance( bankAccount.getBalance() );
        List<Transaction> list = bankAccount.getTransactions();
        if ( list != null ) {
            bankAccountDTO.setTransactions( new ArrayList<Transaction>( list ) );
        }

        return bankAccountDTO;
    }

    protected List<BankAccountDTO> bankAccountListToBankAccountDTOList(List<BankAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<BankAccountDTO> list1 = new ArrayList<BankAccountDTO>( list.size() );
        for ( BankAccount bankAccount : list ) {
            list1.add( bankAccountToBankAccountDTO( bankAccount ) );
        }

        return list1;
    }
}
