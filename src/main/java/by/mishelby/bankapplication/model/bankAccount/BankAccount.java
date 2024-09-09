package by.mishelby.bankapplication.model.bankAccount;

import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
public class BankAccount {
    private Long id;

    private BigDecimal balance;

    @JsonIgnoreProperties
    private User owner;

    @JsonIgnoreProperties
    private List<Transaction> transactions;

    public BankAccount() {
        this.transactions = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }

    public BankAccount(Long id, User owner) {
        this.id = id;
        this.balance = BigDecimal.ZERO;
        this.owner = owner;
        this.transactions = new ArrayList<>();
    }
}