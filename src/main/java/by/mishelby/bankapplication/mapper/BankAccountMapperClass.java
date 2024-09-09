package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountMapperClass implements RowMapper<BankAccount> {
    @Override
    public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        var bankAccount = new BankAccount();
        var ownerId = rs.getLong("owner_id");

        bankAccount.setId(rs.getLong("account_id"));
        bankAccount.setBalance(rs.getBigDecimal("balance"));

        if (ownerId != 0) {
            var user = new User();
            user.setId(ownerId);
            bankAccount.setOwner(user);
        }

        return bankAccount;
    }
}
