package by.mishelby.bankapplication.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountTransferDTO {
    @NotNull
    private BigDecimal amount;

    @NotNull
    private Integer toId;
}
