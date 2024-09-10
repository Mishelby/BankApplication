package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.mapper.BankAccountMapper.BankAccountMapperClass;
import by.mishelby.bankapplication.model.bankAccount.BankAccount;

import by.mishelby.bankapplication.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
@Repository
@RequiredArgsConstructor
public class BankAccountRepositoryImpl implements BankAccountRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final UserRepositoryImpl userRepository;
    private final KeyHolder keyHolder;

    @Override
    @Transactional(readOnly = true)
    public Collection<BankAccount> findAll() {
        var sql = "SELECT b.account_id, b.balance, b.owner_id, t.transaction_id, t.account_id, t.value, t.category, t.created_date, t.type" +
                " FROM bank_repository.bank_account b " +
                " LEFT JOIN bank_repository.transactions t ON b.account_id = t.account_id";
        return jdbcTemplate.query(sql, new BankAccountMapperClass());
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccount findById(Long id) {
        var sql = "SELECT b.account_id, b.balance, b.owner_id " +
                "FROM bank_repository.bank_account b " +
                "WHERE account_id = :id";

        var params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, params, new BankAccountMapperClass())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Bank account with id " + id + " not found"));
    }

    @Override
    @Transactional
    public BankAccount save(Long userId) {
        var user = userRepository.findById(userId);
        if (user.getBankAccounts() == null) {
            user.setBankAccounts(new ArrayList<>());
        }
        var sql = "INSERT INTO bank_repository.bank_account(owner_id, balance) VALUES (:ownerId, :balance)";

        var params = new MapSqlParameterSource()
                .addValue("ownerId", user.getId())
                .addValue("balance", BigDecimal.ZERO);

        namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[]{"account_id"});

        var key = keyHolder.getKey();
        if (key == null) {
            throw new ResourceNotFoundException("Failed to get bank account key");
        }

        var bankAccount = new BankAccount(key.longValue(), user);
        user.getBankAccounts().add(bankAccount);

        return bankAccount;
    }

    @Override
    @Transactional
    public void deleteBankAccount(Long id) {
        var sql = "DELETE FROM bank_repository.bank_account WHERE account_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
