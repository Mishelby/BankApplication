package by.mishelby.bankapplication.mapper.BankAccountMapper;

import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccount toEntity(BankAccountDTO bankAccount);

    BankAccountDTO toDTO(BankAccount bankAccount);

    List<BankAccountDTO> toDTO(List<BankAccount> bankAccounts);

}
