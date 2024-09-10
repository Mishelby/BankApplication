package by.mishelby.bankapplication.model.dto.TransactionDTO;

import by.mishelby.bankapplication.model.transaction.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDTO {
    @NotNull(message = "Id should not be null")
    @NotEmpty(message = "Id should not be an empty")
    private Integer id;

    @NotNull(message = "Transaction value cannot be null")
    @Positive(message = "Transaction value must be positive")
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Transaction type cannot be null")
    private TransactionType type;

    private Integer bankAccountId;

    @NotNull(message = "Transaction category cannot be blank")
    private String category;

    @NotNull(message = "Transaction date cannot be null")
    private LocalDateTime createdDate;
}
