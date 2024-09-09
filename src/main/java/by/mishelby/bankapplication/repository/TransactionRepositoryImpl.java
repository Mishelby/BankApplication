package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.mapper.TransactionMapperClass;
import by.mishelby.bankapplication.model.dto.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder;

    @Override
    @Transactional(readOnly = true)
    public Collection<Transaction> findAll() {
        var sql = "SELECT * FROM bank_repository.transactions";
        return jdbcTemplate.query(sql, new TransactionMapperClass());
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction findById(Long id) {
        var sql = "SELECT transaction_id, value, type, account_id, category, created_date FROM bank_repository.transactions WHERE transaction_id = :id";

        var params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, params, new TransactionMapperClass())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " not found"));
    }

    @Override
    @Transactional
    public Transaction create(TransactionCreateDTO transactionCreateDTO) {
        var sql = "INSERT INTO bank_repository.transactions(value, type, category) VALUES(:value, :type, :category)";

        var params = new MapSqlParameterSource()
                .addValue("value", transactionCreateDTO.getValue())
                .addValue("type", transactionCreateDTO.getType())
                .addValue("category", transactionCreateDTO.getCategory());

        namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[]{"transaction_id"});

        var key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to get transaction key");
        }

        var transaction = new Transaction();
        transaction.setId(key.longValue());

        return transaction;
    }

    @Override
    @Transactional
    public Transaction update(Long id, TransactionUpdateDTO transactionUpdateDTO) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var sql = "DELETE FROM bank_repository.transactions WHERE transaction_id = :id";
        jdbcTemplate.update(sql, id);
    }
}
