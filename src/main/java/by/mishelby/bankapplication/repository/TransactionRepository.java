package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;

import java.util.Collection;


public interface TransactionRepository {
    Collection<Transaction> findAll();

    Transaction findById(Long id);

    Transaction create(TransactionCreateDTO transactionCreateDTO);

    Transaction update(Long id, TransactionUpdateDTO transactionUpdateDTO);

    void delete(Long id);
}
