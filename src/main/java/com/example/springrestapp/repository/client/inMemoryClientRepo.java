package com.example.springrestapp.repository.client;

import com.example.springrestapp.client.Client;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class inMemoryClientRepo implements ClientRepository {
    public static final Map<Integer, Client> clientMap;

    static {
        clientMap = new HashMap<>();
        clientMap.put(1,Client.builder()
                .firstName("Piotr")
                .lastName("Kus")
                .email("kus@gmail.com")
                .phoneNumber("511511511")
                .yearOfBirth(1988)
                .pesel("88010101001")
                .isPremium(true)
                .build());
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public List<Client> addClinet(Integer idNumber, Client newClient) {
        clientMap.put(idNumber, newClient);
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public Optional<Client> showClientInfo(Integer idNumber) {
        return Optional.ofNullable(clientMap.get(idNumber));
    }

    @Override
    public Map<Integer, Client> updateClient(Integer idNumber, Client client) {
        Client client1 = clientMap.get(idNumber);
        if (client1 != null) {
            client1.setFirstName(client.getFirstName());
            client1.setLastName(client.getLastName());
            client1.setEmail(client.getEmail());
            client1.setPhoneNumber(client.getPhoneNumber());
            client1.setYearOfBirth(client.getYearOfBirth());
            client1.setPesel(client.getPesel());
            client1.setIsPremium(client.getIsPremium());
        }
        return clientMap;
    }

    @Override
    public Optional<Client> deleteClient(Integer idNumber) {
        return Optional.ofNullable(clientMap.remove(idNumber));
    }
}
