package com.spring.BankingSystemSpring.service.accountService;

import com.spring.BankingSystemSpring.Entity.Account;
import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account findById(int accountId) throws BankSystemException;
    public Account save(Account account) throws BankSystemException;
    public void deleteById(int accountId);

}
