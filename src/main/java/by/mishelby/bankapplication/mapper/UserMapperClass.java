package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.user.User;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapperClass implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        var user = new User();
        user.setId(rs.getLong("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setMiddleName(rs.getString("middle_name"));
        user.setLastName(rs.getString("last_name"));
        user.setBirthDate(rs.getDate("birth_date").toLocalDate());
        user.setBankAccounts(new ArrayList<>());

        Long accountId = rs.getLong("account_id");
        if (accountId != null) {
            var bankAccount = new BankAccount();
            bankAccount.setId(accountId);
            bankAccount.setOwner(user);
            bankAccount.setBalance(rs.getBigDecimal("balance"));
            user.getBankAccounts().add(bankAccount);
        }

        return user;
    }
}
