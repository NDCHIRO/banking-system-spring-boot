package com.spring.BankingSystemSpring.service.clientService;

import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;

import java.util.List;

public interface ClientService {
    public List<Client> findAll();
    public Client findById(int employeeId);
    public Client save(Client theEmployee) throws BankSystemException;
    public void deleteById(int employeeId);
}