package by.mishelby.bankapplication.model.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountAmount {
    @NotNull(message = "Amount should not be null")
    private BigDecimal amount;

    private BankAccountTransferDTO bankAccountTransferDTO;
}
