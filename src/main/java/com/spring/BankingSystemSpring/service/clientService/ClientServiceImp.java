package com.spring.BankingSystemSpring.service.clientService;

import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.dao.clientDao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    private ClientDAO clientDAO;

    @Autowired
    public ClientServiceImp(ClientDAO theClientDAO)
    {
        clientDAO=theClientDAO;
    }
    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client findById(int clientId) {
        return clientDAO.findById(clientId);
    }

    @Override
    public Client save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public void deleteById(int clientId) {
        clientDAO.deleteById(clientId);
    }
}
