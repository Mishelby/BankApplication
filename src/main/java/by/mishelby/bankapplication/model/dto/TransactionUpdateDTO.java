package by.mishelby.bankapplication.model.dto;

import by.mishelby.bankapplication.model.transaction.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionUpdateDTO {
    @NotNull(message = "Transaction value cannot be null")
    @Positive(message = "Transaction value must be positive")
    private BigDecimal value;

    @NotNull(message = "Transaction type cannot be null")
    private TransactionType type;

    @NotNull(message = "Transaction category cannot be null")
    private String category;
}
