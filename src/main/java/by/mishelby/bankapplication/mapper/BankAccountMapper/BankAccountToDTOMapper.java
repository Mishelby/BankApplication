package by.mishelby.bankapplication.mapper.BankAccountMapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountToDTOMapper {

    public BankAccountDTO toDTO(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setOwnerId(bankAccount.getOwner().getId());
        bankAccountDTO.setBalance(bankAccount.getBalance());
        bankAccountDTO.setTransactions(new ArrayList<>(List.of()));

        List<Transaction> transactions = bankAccount.getTransactions();
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                bankAccountDTO.getTransactions().add(transaction);
            }
        }
        return bankAccountDTO;
    }
}
