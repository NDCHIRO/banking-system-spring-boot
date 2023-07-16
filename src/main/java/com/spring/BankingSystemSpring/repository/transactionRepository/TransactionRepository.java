package com.spring.BankingSystemSpring.repository.transactionRepository;

import com.spring.BankingSystemSpring.Entity.Transaction;
import org.hibernate.dialect.H2Dialect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
