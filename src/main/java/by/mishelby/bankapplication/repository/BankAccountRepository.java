package by.mishelby.bankapplication.repository;


import by.mishelby.bankapplication.model.bankAccount.BankAccount;

import java.util.Collection;
import java.util.Optional;

public interface BankAccountRepository {
    Collection<BankAccount> findAll();

    BankAccount findById(Long id);

    BankAccount save(Long userId);

    void deleteBankAccount(Long id);
}
