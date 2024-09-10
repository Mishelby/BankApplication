package by.mishelby.bankapplication.model.dto.BankAccountDTO;

import by.mishelby.bankapplication.model.transaction.Transaction;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class BankAccountDTO {
    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance cannot be negative")
    private BigDecimal balance;

    @NotNull(message = "Owner cannot be null")
    private Long ownerId;

    @NotNull(message = "Transaction list should not be null")
    @NotEmpty(message = "Transaction list should not be an empty")
    private List<Transaction> transactions;

    public BankAccountDTO(BigDecimal balance, Long ownerId, List<Transaction> transactions) {
        this.balance = balance;
        this.ownerId = ownerId;
        this.transactions = transactions;
    }
}
