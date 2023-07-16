package com.spring.BankingSystemSpring.service.transactionService;

import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.Entity.Transaction;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;

import java.util.List;

public interface TransactionService {
    public List<Transaction> findAll();
    public Transaction findById(int transactionId) throws BankSystemException;
    public Transaction save(Transaction theTransaction);
    public void deleteById(int transactionId);
}
