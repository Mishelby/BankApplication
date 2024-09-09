package by.mishelby.bankapplication.service;

import by.mishelby.bankapplication.model.dto.BankAccountAmount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO;
import by.mishelby.bankapplication.model.dto.BankAccountTransferDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;


import java.math.BigDecimal;
import java.util.*;

public interface BankAccountService {
    // Bank operations
    BankAccountDTO topUpBankAccount(int id, BankAccountAmount bankAccountAmount);

    BankAccountDTO withdrawalFromBankAccount(int id, BankAccountAmount bankAccountAmount);

    BankAccountDTO transferFromBankAccount(int fromId, BankAccountTransferDTO bankAccountTransferDTO);

    BigDecimal getMonthlySpendingByCategory(int id, String category);

    Map<String, BigDecimal> getMonthlySpendingByCategories(int userId, Set<String> categories);

    Map<String, List<Transaction>> getTransactionHistorySortedByAmount(int userId);

    List<Transaction> getLastNTransactions(int userId, int n);

    PriorityQueue<Transaction> getTopNLargestTransactions(int userId, int n);

    boolean isNewResource(BankAccountDTO bankAccount);
}
