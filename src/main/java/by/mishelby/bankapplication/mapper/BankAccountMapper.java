package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccount toEntity(BankAccountDTO bankAccount);

    BankAccountDTO toDTO(BankAccount bankAccount);

}
