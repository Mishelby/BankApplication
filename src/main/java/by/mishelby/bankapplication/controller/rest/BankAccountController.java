package by.mishelby.bankapplication.controller.rest;

import by.mishelby.bankapplication.mapper.BankAccountMapper.BankAccountMapper;
import by.mishelby.bankapplication.mapper.BankAccountMapper.BankAccountMapperMain;
import by.mishelby.bankapplication.model.bankAccount.BankAccount;
import by.mishelby.bankapplication.model.dto.BankAccountDTO.BankAccountDTO;
import by.mishelby.bankapplication.repository.BankAccountRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@RestController("bankAccountRestController")
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountRepositoryImpl bankAccountRepository;
    private final BankAccountMapperMain bankAccountMapperMain;
    private final BankAccountMapper bankAccountMapper;


    @GetMapping("/accounts")
    public Iterable<BankAccountDTO> getAllAccounts() {
        Collection<BankAccount> bankAccountsList = bankAccountRepository.findAll();
        return bankAccountsList
                .stream()
                .map(bankAccountMapperMain::toDTO)
                .toList();
    }

    @GetMapping("/account/{id}")
    public BankAccountDTO getById(@PathVariable Long id) {
        var bankAccount = bankAccountRepository.findById(id);
        return bankAccountMapper.toDTO(bankAccount);
    }

    @PostMapping("/account/{id}")
    public ResponseEntity<BankAccountDTO> create(@PathVariable("id") Long id) {
        var bankAccount = bankAccountRepository.save(id);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bankAccount.getId())
                .toUri();

        return ResponseEntity.created(location).body(
                bankAccountMapperMain.toDTO(bankAccount)
        );
    }


    @DeleteMapping("/account/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        bankAccountRepository.deleteBankAccount(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/account/{id}/spending/category/{category}")
//    public ResponseEntity<BigDecimal> getSpending(@PathVariable("id") int id,
//                                                  @PathVariable("category") String category) {
//        var monthlySpendingByCategory = bankAccountService.getMonthlySpendingByCategory(id, category);
//        return ResponseEntity.ok().body(monthlySpendingByCategory);
//    }
//
//    @GetMapping("/account/{id}/spending")
//    public ResponseEntity<Map<String, BigDecimal>> getMonthlySpending(@PathVariable("id") int id,
//                                                                      @RequestParam("categories") Set<String> categories) {
//        Map<String, BigDecimal> monthlySpendingByCategories = bankAccountService.getMonthlySpendingByCategories(id, categories);
//        return ResponseEntity.ok().body(monthlySpendingByCategories);
//    }
//
//    @GetMapping("/account/{id}/transactions/sorted-by-amount")
//    public ResponseEntity<Map<String, List<Transaction>>> getAmountTransaction(@PathVariable("id") int id) {
//        Map<String, List<Transaction>> transactionHistorySortedByAmount = bankAccountService.getTransactionHistorySortedByAmount(id);
//        return ResponseEntity.ok().body(transactionHistorySortedByAmount);
//    }
//
//    @GetMapping("/account/{id}/transactions/last")
//    public ResponseEntity<List<Transaction>> getNLastTransactions(@PathVariable("id") int id,
//                                                                  @RequestParam("count") int count) {
//        List<Transaction> lastNTransactions = bankAccountService.getLastNTransactions(id, count);
//        return ResponseEntity.ok().body(lastNTransactions);
//    }
//
//    @GetMapping("/account/{id}/transactions/top")
//    public ResponseEntity<PriorityQueue<Transaction>> getTopNLastTransactions(@PathVariable("id") int id,
//                                                                              @RequestParam("count") int count) {
//        PriorityQueue<Transaction> lastTopNTransactions = bankAccountService.getTopNLargestTransactions(id, count);
//        return ResponseEntity.ok().body(lastTopNTransactions);
//    }
//
//    @PostMapping("/account/{id}/action")
//    public ResponseEntity<BankAccountDTO> topUp(@PathVariable("id") int id,
//                                                @Valid @RequestBody BankAccountAmount bankAccountAmount,
//                                                @RequestParam("action") BankAccountAction action) {
//
//        BankAccountDTO bankAccount = switch (action) {
//            case TOP_UP -> bankAccountService.topUpBankAccount(id, bankAccountAmount);
//            case WITHDRAW -> bankAccountService.withdrawalFromBankAccount(id, bankAccountAmount);
//            case TRANSFER -> bankAccountService.transferFromBankAccount(id, bankAccountAmount.getBankAccountTransferDTO());
//            default -> throw new IllegalArgumentException("Invalid action type");
//        };
//
//        if (bankAccountService.isNewResource(bankAccount)) {
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(bankAccount.getId())
//                    .toUri();
//
//            return ResponseEntity.created(location).body(bankAccount);
//        }
//
//        return ResponseEntity.ok().body(bankAccount);
//    }


}
