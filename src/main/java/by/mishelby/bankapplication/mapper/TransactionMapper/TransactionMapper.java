package by.mishelby.bankapplication.mapper.TransactionMapper;

import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction trancastionCreateToTransaction(TransactionCreateDTO transactionCreateDTO);

    Transaction trancastionUpdateToTransaction(TransactionUpdateDTO transactionUpdateDTO);

    Transaction toEntity(TransactionDTO transactionDTO);

    TransactionDTO toDTO(Transaction transaction);
}
