package by.mishelby.bankapplication.model.dto;

import by.mishelby.bankapplication.model.transaction.Transaction;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class BankAccountDTO {
    @NotNull(message = "Id should not be null")
    @NotEmpty(message = "Id should not be an empty")
    private Integer id;

    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance cannot be negative")
    private BigDecimal balance;

    @NotNull(message = "Owner cannot be null")
    private Integer ownerId;

    @NotNull(message = "Transaction list should not be null")
    @NotEmpty(message = "Transaction list should not be an empty")
    private List<Transaction> transactions;
}
