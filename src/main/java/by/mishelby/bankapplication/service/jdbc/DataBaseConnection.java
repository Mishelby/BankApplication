package by.mishelby.bankapplication.service.jdbc;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DataBaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/BankApplicationDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "C3hmiCmY";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
