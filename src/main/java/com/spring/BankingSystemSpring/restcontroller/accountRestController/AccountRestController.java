package com.spring.BankingSystemSpring.restcontroller.accountRestController;

import com.spring.BankingSystemSpring.Entity.Account;
import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.service.accountService.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountapi")
public class AccountRestController {
    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService theAccountService) {
        accountService = theAccountService;
    }

    //  url:  http://localhost:8086/accountapi/accounts
    @GetMapping("/accounts")
    public List<Account> findAll()
    {
        return accountService.findAll();
    }
    @GetMapping("/accounts/{accountId}")
    public Account findById(@PathVariable int accountId) throws BankSystemException {
        return accountService.findById(accountId);
    }

    @Transactional
    @PostMapping("/accounts")
    public Account save(@RequestBody Account account) throws BankSystemException {
        return accountService.save(account);
    }

    @PutMapping("/accounts")
    public Account update(@RequestBody Account account) throws BankSystemException {
        return accountService.save(account);
    }

    @DeleteMapping("/accounts/{accountId}")
    @Transactional
    public String deleteById(@PathVariable int accountId) throws BankSystemException {
        Account account=accountService.findById(accountId);
        if(account == null)
            throw new BankSystemException("account no."+accountId +" not found");
        accountService.deleteById(accountId);
        return "client no."+accountId+" deleted";
    }
}
