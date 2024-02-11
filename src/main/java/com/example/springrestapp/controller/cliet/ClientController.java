package com.example.springrestapp.controller.cliet;

import com.example.springrestapp.Client.Client;
import com.example.springrestapp.model.Car;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Slf4j
public class ClientController {
    public static List<Client> clientsList = new ArrayList<>();
    @PostMapping("/addClient")
    public ResponseEntity<List<Client>> addClient( @RequestBody @Valid Client client){
        log.info(client.toString());
        clientsList.add(client);
        return ResponseEntity.ok(clientsList);
    }
}
