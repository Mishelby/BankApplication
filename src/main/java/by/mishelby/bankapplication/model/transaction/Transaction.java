package by.mishelby.bankapplication.model.transaction;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class Transaction {
    private Long id;

    private BigDecimal value;

    private TransactionType type;

    @ToString.Exclude
    @JsonBackReference
    private BankAccount bankAccount;

    private String category;

    private LocalDateTime createdDate;

    public Transaction(BankAccount bankAccount, String category, TransactionType type, BigDecimal value) {
        this.bankAccount = bankAccount;
        this.category = category;
        this.type = type;
        this.value = value;
        this.createdDate = LocalDateTime.now();
    }

    public Transaction() {
    }
}
