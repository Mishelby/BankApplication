package by.mishelby.bankapplication.mapper.UserMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.user.User;
import org.springframework.jdbc.core.RowMapper;

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

        long accountId = rs.getLong("account_id");

        if (accountId > 0) {
            var account = new BankAccount();
            account.setId(accountId);
            account.setOwner(user);
            account.setBalance(rs.getBigDecimal("balance"));
            user.getBankAccounts().add(account);
        }


        return user;
    }
}

