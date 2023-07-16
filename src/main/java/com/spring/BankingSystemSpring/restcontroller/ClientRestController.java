package com.spring.BankingSystemSpring.restcontroller;

import com.spring.BankingSystemSpring.Entity.Client;
import com.spring.BankingSystemSpring.ServiceUtility.BankSystemException;
import com.spring.BankingSystemSpring.service.accountService.AccountService;
import com.spring.BankingSystemSpring.service.clientService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientapi")
public class ClientRestController {
    private ClientService clientService;
    @Autowired
    public ClientRestController(ClientService theClientService)
    {
        clientService=theClientService;
    }

    //  url:  http://localhost:8086/api/clients
    @GetMapping("/clients")
    public List<Client> findAll()
    {
        return clientService.findAll();
    }
    @GetMapping("/clients/{clientId}")
    public Client findById(@PathVariable int clientId)
    {
        return clientService.findById(clientId);
    }

    @Transactional
    @PostMapping("/clients")
    public Client save(@RequestBody Client client) throws BankSystemException {
        return clientService.save(client);
    }

    @PutMapping("/clients")
    public Client update(@RequestBody Client client) throws BankSystemException {
        return clientService.save(client);
    }

    @DeleteMapping("/clients/{clientId}")
    @Transactional
    public String deleteById(@PathVariable int clientId) throws BankSystemException {
        Client client=clientService.findById(clientId);
        if(client == null)
            throw new BankSystemException("client not found");
        clientService.deleteById(clientId);
        return "client no."+clientId+" deleted";
    }
}
