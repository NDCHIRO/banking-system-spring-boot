package com.spring.BankingSystemSpring.dao.clientDao;

import com.spring.BankingSystemSpring.Entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImp implements ClientDAO {

    private EntityManager entityManager;
    @Autowired
    public ClientDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> query = entityManager.createQuery("from Client",Client.class);
        List<Client> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Client findById(int clientId) {
        Client employee = entityManager.find(Client.class,clientId);
        return employee;
    }

    @Override
    public Client save(Client theClient) {
        //if id=0 then it will insert a new employee
        // else it will update the employee's data
        Client employee = entityManager.merge(theClient);
        return employee;
    }

    @Override
    public void deleteById(int clientId) {
        Client client = entityManager.find(Client.class,clientId);
        entityManager.remove(client);
    }
}
