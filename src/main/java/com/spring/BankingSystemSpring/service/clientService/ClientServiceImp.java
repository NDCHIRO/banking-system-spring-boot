package com.spring.BankingSystemSpring.service.clientService;

import com.spring.BankingSystemSpring.Entity.Account;
import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.repository.accountRepository.AccountRepository;
import com.spring.BankingSystemSpring.repository.clientRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository)
    {
        this.clientRepository=clientRepository;
    }

    public ClientServiceImp(AccountRepository accountRepository)
    {
        this.accountRepository=accountRepository;
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int clientId) {
        Optional<Client> result = clientRepository.findById(clientId);
        Client client = null;
        if(result.isPresent())      //it means if result is not null
            client=result.get();
        else    // if result is null
            throw new RuntimeException("client no."+clientId+" doesn't exist");

        return client;
    }

    @Override
    public Client save(Client client) throws BankSystemException {
        if(client.getName().length()<3)
            throw new BankSystemException("username must be greater than 2");
        Account account = new Account();
        account.setClient(client);
        account.setAmount(0);
        accountRepository.save(account);
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
