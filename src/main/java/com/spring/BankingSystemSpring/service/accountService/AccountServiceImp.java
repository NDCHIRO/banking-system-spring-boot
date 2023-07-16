package com.spring.BankingSystemSpring.service.accountService;

import com.spring.BankingSystemSpring.Entity.Account;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.repository.accountRepository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository theAccountRepository)
    {
        accountRepository = theAccountRepository;
    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int accountId) throws BankSystemException {
        Optional<Account> result = accountRepository.findById(accountId);
        Account account=null;
        if(result.isPresent())
            account=result.get();
        else
            throw new BankSystemException("account no."+accountId+" doesn't exist");
        return account;
    }

    @Override
    public Account save(Account account) throws BankSystemException {
        if(account.getClient()==null)
            throw new BankSystemException("there is no client to create account");
        return accountRepository.save(account);
    }

    @Override
    public String deleteById(int accountId) {
        accountRepository.deleteById(accountId);
        return "account no."+accountId+" deleted";
    }
}
