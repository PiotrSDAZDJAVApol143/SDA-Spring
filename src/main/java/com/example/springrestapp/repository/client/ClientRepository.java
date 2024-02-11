package com.example.springrestapp.repository.client;

import com.example.springrestapp.client.Client;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAllClients();

    List<Client> addClinet(Integer idNumber, Client newClient);

    Optional<Client> showClientInfo(Integer idNumber);

    Map<Integer, Client> updateClient(Integer idNumber, Client client);

    Optional<Client> deleteClient(Integer idNumber);
}
