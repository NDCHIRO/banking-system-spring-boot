package com.spring.BankingSystemSpring.repository.accountRepository;

import com.spring.BankingSystemSpring.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
