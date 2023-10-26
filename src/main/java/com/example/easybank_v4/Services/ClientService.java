package com.example.easybank_v4.Services;

import com.example.easybank_v4.Interfaces.ClientInterface;
import com.example.easybank_v4.DTO.Client;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private ClientInterface clientDao;
    public ClientService(ClientInterface clientDao)
    {
        this.clientDao = clientDao;
    }

    public Optional<Client> saveClient(Client client)
    {
        if (client == null) {
            return Optional.empty();
        }
        return clientDao.save(client);
    }

    public int deleteClient(Client client)
    {
        if (client == null) {
            return 0;
        }
        return clientDao.delete(client);
    }
    public Optional<Client> updateClient(Client client)
    {
        if (client == null) {
            return Optional.empty();
        }
        return clientDao.update(client);
    }
    public Optional<Client> findByIdClient(String id)
    {
        if (id == null) {
            return Optional.empty();
        }
        return clientDao.findById(id);
    }
    public List<Client> showAllClient()
    {
        return clientDao.showAll();
    }
    public List<Client> searchByAttribute(String attribute)
    {
        return clientDao.searchByAttribute(attribute);
    }
}
