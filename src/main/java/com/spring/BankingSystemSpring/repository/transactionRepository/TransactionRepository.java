package com.spring.BankingSystemSpring.repository.transactionRepository;

import org.hibernate.Transaction;
import org.hibernate.dialect.H2Dialect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
