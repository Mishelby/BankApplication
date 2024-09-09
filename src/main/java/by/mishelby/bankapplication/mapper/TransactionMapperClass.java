package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.model.transaction.TransactionType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapperClass implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        var transaction = new Transaction();
        var typeString = rs.getString("type");
        var type = TransactionType.valueOf(typeString);
        var sqlDate = rs.getTimestamp("created_date");

        transaction.setId(rs.getLong("transaction_id"));
        transaction.setCategory(rs.getString("category"));
        transaction.setValue(rs.getBigDecimal("value"));
        transaction.setType(type);
        transaction.setCreatedDate(sqlDate.toLocalDateTime());


        var accountId = rs.getLong("account_id");
        if (accountId > 0) {
            var account = new BankAccount();
            account.setId(accountId);
            transaction.setBankAccount(account);
        }

        return transaction;
    }
}
