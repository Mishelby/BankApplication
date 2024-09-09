package by.mishelby.bankapplication.controller.rest;

import by.mishelby.bankapplication.model.dto.TransactionCreateDTO;
import by.mishelby.bankapplication.model.dto.TransactionDTO;
import by.mishelby.bankapplication.model.dto.TransactionUpdateDTO;
import by.mishelby.bankapplication.mapper.TransactionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@Slf4j
@RestController("transactionRestController")
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
//    private final TransactionServiceImpl transactionService;
//    private final TransactionMapper transactionMapper;
//
//    @GetMapping("/transactions")
//    public ResponseEntity<Iterable<TransactionDTO>> getAllTransactions() {
//        Collection<TransactionDTO> transactions = transactionService.findAll();
//        if (transactions.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok().body(transactions);
//    }
//
//    @GetMapping("/transaction/{id}")
//    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable("id") int id) {
//        var transaction = transactionService.findById(id);
//        return ResponseEntity.ok().body(transaction);
//    }
//
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
