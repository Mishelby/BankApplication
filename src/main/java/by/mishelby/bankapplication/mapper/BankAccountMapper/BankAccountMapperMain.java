package by.mishelby.bankapplication.mapper.BankAccountMapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapperMain {

    public BankAccountDTO toDTO(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }
        var bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setOwnerId(bankAccount.getOwner().getId());
        bankAccountDTO.setBalance(bankAccount.getBalance());
        if (bankAccount.getTransactions() != null) {
            bankAccountDTO.setTransactions(bankAccount.getTransactions());
        }

        return bankAccountDTO;
    }
}
