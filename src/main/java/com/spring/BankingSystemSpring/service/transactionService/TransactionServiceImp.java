package com.spring.BankingSystemSpring.service.transactionService;

import com.spring.BankingSystemSpring.Entity.Transaction;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.repository.transactionRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImp(TransactionRepository transactionRepository)
    {
        this.transactionRepository=transactionRepository;
    }


    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(int transactionId) throws BankSystemException {
        Optional<Transaction> result = transactionRepository.findById(transactionId);
        Transaction transaction=null;
        if(result.isPresent())
            transaction=result.get();
        else
            throw new BankSystemException("transaction not found");
        return transaction;
    }

    @Override
    public Transaction save(Transaction theTransaction)  {
        return transactionRepository.save(theTransaction);
    }

    @Override
    public void deleteById(int transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
