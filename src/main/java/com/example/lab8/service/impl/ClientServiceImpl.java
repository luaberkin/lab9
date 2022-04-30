package com.example.lab8.service.impl;

import com.example.lab8.model.Client;
import com.example.lab8.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements com.example.lab8.service.ClientService {

    private final ClientRepository clientRepository;

    @Autowired(required = true)
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getCLients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Optional<Client> client1 = clientRepository.findById(id);
        if (client1.isPresent()) {
            Client _client = client1.get();
            _client.setFirstName(client.getFirstName());
            _client.setLastName(client.getLastName());
            _client.setUsername(client.getUsername());
            _client.setPassword(client.getPassword());
            return clientRepository.save(_client);
        } else {
            return null;
        }
    }

    public void deleteClientById(Long id) {
        this.clientRepository.deleteById(id);
    }
}
