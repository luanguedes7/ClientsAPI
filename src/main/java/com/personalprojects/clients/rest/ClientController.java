package com.personalprojects.clients.rest;

import com.personalprojects.clients.model.entity.Client;
import com.personalprojects.clients.model.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @GetMapping
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        clientRepository
                .findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Client not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client newClient) {
        clientRepository
                .findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setCPF(newClient.getCPF());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Client not found"));
    }
}
