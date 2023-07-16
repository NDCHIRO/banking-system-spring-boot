package com.spring.BankingSystemSpring.repository.clientRepository;

import com.spring.BankingSystemSpring.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
