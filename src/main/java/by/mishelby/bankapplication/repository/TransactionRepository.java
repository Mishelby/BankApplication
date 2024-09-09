package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.model.dto.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface TransactionRepository {
    Collection<Transaction> findAll();

    Transaction findById(Long id);

    Transaction create(TransactionCreateDTO transactionCreateDTO);

    Transaction update(Long id, TransactionUpdateDTO transactionUpdateDTO);

    void delete(Long id);
}
