package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.dto.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO;
import by.mishelby.bankapplication.model.dto.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction trancastionCreateToTransaction(TransactionCreateDTO transactionCreateDTO);

    Transaction trancastionUpdateToTransaction(TransactionUpdateDTO transactionUpdateDTO);

    Transaction toEntity(TransactionDTO transactionDTO);

    TransactionDTO toDTO(Transaction transaction);
}
