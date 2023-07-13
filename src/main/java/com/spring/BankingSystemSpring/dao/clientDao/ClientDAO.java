package com.spring.BankingSystemSpring.dao.clientDao;

import com.spring.BankingSystemSpring.Entity.Client;

import java.util.List;

public interface ClientDAO {
    public List<Client> findAll();
    public Client findById(int clientId);
    public Client save(Client theClient);
    public void deleteById(int clientId);

}