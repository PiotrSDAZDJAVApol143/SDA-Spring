package com.example.springrestapp.service.client;

import com.example.springrestapp.client.Client;
import com.example.springrestapp.repository.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }
    public List<Client> addClient(Integer idNumber, Client newClient){
        return clientRepository.addClinet(idNumber,newClient);
    }
    public Optional<Client>showClientInfo(Integer idNumber){
        return clientRepository.showClientInfo(idNumber);
    }
    public Map<Integer,Client> updateClientData(Integer idNumber, Client updatedClient ){
        return clientRepository.updateClient(idNumber,updatedClient);
    }
    public Optional<Client> deleteClient(Integer idNumber){
        return clientRepository.deleteClient(idNumber);
    }

}
