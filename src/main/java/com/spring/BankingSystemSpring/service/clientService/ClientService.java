package com.spring.BankingSystemSpring.service.clientService;

import com.spring.BankingSystemSpring.Entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> findAll();
    public Client findById(int employeeId);
    public Client save(Client theEmployee);
    public void deleteById(int employeeId);
}
