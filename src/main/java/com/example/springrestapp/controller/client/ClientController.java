package com.example.springrestapp.controller.client;

import com.example.springrestapp.client.Client;
import com.example.springrestapp.exceptions.ClientNotFoundException;
import com.example.springrestapp.service.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Slf4j
public class ClientController {
    private final ClientService clientsList;
    @GetMapping("/showAll")
    public ResponseEntity<List<Client>>getAllClients(){
        log.info("Otrzymalismy request wyswietlenia wszystkich klientow");
        List<Client>allClients = clientsList.getAllClients();
        return ResponseEntity.ok(allClients);
    }
    @PostMapping("/addClient/{idNumber}")
    public ResponseEntity<List<Client>> addClient(@PathVariable Integer idNumber,  @RequestBody @Valid Client client){
        log.info(client.toString());
        return ResponseEntity.ok(clientsList.addClient(idNumber,client));
    }
    @GetMapping("/showClientInfo/{idNumber}")
    public ResponseEntity<Client>showClientInfo(@RequestParam Integer idNumber){
        log.info("Otrzymalismy request wyswietlenia klienta o id: " + idNumber);
        return clientsList.showClientInfo(idNumber)
                .map(client -> ResponseEntity.ok(client))
                .orElseThrow(()-> new ClientNotFoundException("Nie znaleziono klienta o podanym id:" +idNumber));
    }
    @PatchMapping("/updateClientDate/{idNumber}")
    public ResponseEntity<Map<Integer,Client>> updateClientData(@PathVariable Integer idNumber, @RequestBody Client updatedClient){
        return ResponseEntity.ok(clientsList.updateClientData(idNumber,updatedClient));
    }
    @DeleteMapping("/deleteClient/{idNumber}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer idNumber){
        log.warn("Otrzymalismy request usuniecia klienta o id: " + idNumber);
        clientsList.deleteClient(idNumber)
                .orElseThrow(()-> new ClientNotFoundException("Nie znaleziono klienta o podanym id:" +idNumber));
        return ResponseEntity.ok().build();
    }




}
