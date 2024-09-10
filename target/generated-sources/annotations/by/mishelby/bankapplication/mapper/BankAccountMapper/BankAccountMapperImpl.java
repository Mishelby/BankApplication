package by.mishelby.bankapplication.mapper.BankAccountMapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
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
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccount toEntity(BankAccountDTO bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccount bankAccount1 = new BankAccount();

        bankAccount1.setBalance( bankAccount.getBalance() );
        List<Transaction> list = bankAccount.getTransactions();
        if ( list != null ) {
            bankAccount1.setTransactions( new ArrayList<Transaction>( list ) );
        }

        return bankAccount1;
    }

    @Override
    public BankAccountDTO toDTO(BankAccount bankAccount) {
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

    @Override
    public List<BankAccountDTO> toDTO(List<BankAccount> bankAccounts) {
        if ( bankAccounts == null ) {
            return null;
        }

        List<BankAccountDTO> list = new ArrayList<BankAccountDTO>( bankAccounts.size() );
        for ( BankAccount bankAccount : bankAccounts ) {
            list.add( toDTO( bankAccount ) );
        }

        return list;
    }
}
