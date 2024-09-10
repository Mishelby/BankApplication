package by.mishelby.bankapplication.mapper.TransactionMapper;

import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionUpdateDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.model.transaction.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T00:15:07+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction trancastionCreateToTransaction(TransactionCreateDTO transactionCreateDTO) {
        if ( transactionCreateDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setValue( transactionCreateDTO.getValue() );
        transaction.setType( transactionCreateDTO.getType() );
        transaction.setCategory( transactionCreateDTO.getCategory() );

        return transaction;
    }

    @Override
    public Transaction trancastionUpdateToTransaction(TransactionUpdateDTO transactionUpdateDTO) {
        if ( transactionUpdateDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setValue( transactionUpdateDTO.getValue() );
        transaction.setType( transactionUpdateDTO.getType() );
        transaction.setCategory( transactionUpdateDTO.getCategory() );

        return transaction;
    }

    @Override
    public Transaction toEntity(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        if ( transactionDTO.getId() != null ) {
            transaction.setId( transactionDTO.getId().longValue() );
        }
        transaction.setValue( transactionDTO.getValue() );
        transaction.setType( transactionDTO.getType() );
        transaction.setCategory( transactionDTO.getCategory() );
        transaction.setCreatedDate( transactionDTO.getCreatedDate() );

        return transaction;
    }

    @Override
    public TransactionDTO toDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        Integer id = null;
        BigDecimal value = null;
        TransactionType type = null;
        String category = null;
        LocalDateTime createdDate = null;

        if ( transaction.getId() != null ) {
            id = transaction.getId().intValue();
        }
        value = transaction.getValue();
        type = transaction.getType();
        category = transaction.getCategory();
        createdDate = transaction.getCreatedDate();

        Integer bankAccountId = null;

        TransactionDTO transactionDTO = new TransactionDTO( id, value, type, bankAccountId, category, createdDate );

        return transactionDTO;
    }
}
