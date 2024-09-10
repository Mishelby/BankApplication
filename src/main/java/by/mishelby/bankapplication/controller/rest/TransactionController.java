package by.mishelby.bankapplication.controller.rest;

import by.mishelby.bankapplication.mapper.TransactionMapper.TransactionMapper;
import by.mishelby.bankapplication.model.dto.TransactionDTO.TransactionDTO;
import by.mishelby.bankapplication.model.transaction.Transaction;
import by.mishelby.bankapplication.repository.TransactionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController("transactionRestController")
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepositoryImpl transactionRepository;
    private final TransactionMapper transactionMapper;

    @GetMapping("/transactions")
    public Iterable<TransactionDTO> getAllTransactions() {
        Collection<Transaction> transactions = transactionRepository.findAll();

        return transactions
                .stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

    @GetMapping("/transaction/{id}")
    public TransactionDTO getTransactionById(@PathVariable("id") Long id) {
        var transaction = transactionRepository.findById(id);
        return transactionMapper.toDTO(transaction);
    }

//    @PostMapping("/transaction")
//    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody @Valid TransactionCreateDTO transactionCreateDTO) {
//        var transaction = transactionService.create(transactionCreateDTO);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(transaction.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).body(transaction);
//    }
//
//    @PatchMapping("/transaction/{id}")
//    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable("id") int id,
//                                                            @RequestBody @Valid TransactionUpdateDTO transactionUpdateDTO) {
//
//        var updateTransaction = transactionService.update(id, transactionUpdateDTO);
//        return ResponseEntity.ok().body(updateTransaction);
//    }
//
//    @DeleteMapping("/transaction/{id}")
//    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable("id") int id) {
//        transactionService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
