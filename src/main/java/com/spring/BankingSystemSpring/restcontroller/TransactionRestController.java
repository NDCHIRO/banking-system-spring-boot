package com.spring.BankingSystemSpring.restcontroller;

import com.spring.BankingSystemSpring.Entity.Transaction;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.service.transactionService.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionapi")
public class TransactionRestController {
    private TransactionService transactionService;
    @Autowired
    public TransactionRestController(TransactionService transactionService)
    {
        this.transactionService=transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions()
    {
        return transactionService.findAll();
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction getTransaction(@PathVariable int transactionId) throws BankSystemException {
        return transactionService.findById(transactionId);
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(Transaction transaction)  {
        return transactionService.save(transaction);
    }

    @PutMapping("/transactions")
    public Transaction updateTransaction(Transaction transaction)  {
        return transactionService.save(transaction);
    }

    @DeleteMapping("/transactions/{transactionId}")
    public String deleteTransaction(@PathVariable int transactionId)
    {
        transactionService.deleteById(transactionId);
        return "transaction no."+transactionId+" deleted successfully";
    }

}
