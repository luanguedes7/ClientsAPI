package com.personalprojects.clients.rest;

import com.personalprojects.clients.model.entity.Client;
import com.personalprojects.clients.model.entity.ServiceProvided;
import com.personalprojects.clients.model.repository.ClientRepository;
import com.personalprojects.clients.model.repository.ServiceProvidedRepository;
import com.personalprojects.clients.rest.dto.ServiceProvidedDTO;
import com.personalprojects.clients.util.BigDecimalConvertion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/service-provided")
public class ServiceProvidedController {

    private final ClientRepository clientRepository;
    private final ServiceProvidedRepository serviceProvidedRepository;
    private final BigDecimalConvertion bigDecimalConvertion;

    public ServiceProvidedController(
            ClientRepository clientRepository,
            ServiceProvidedRepository serviceProvidedRepository,
            BigDecimalConvertion bigDecimalConvertion) {
        this.clientRepository = clientRepository;
        this.serviceProvidedRepository = serviceProvidedRepository;
        this.bigDecimalConvertion = bigDecimalConvertion;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceProvided save(@RequestBody ServiceProvidedDTO serviceProvidedDTO) {
        LocalDate date = LocalDate.parse(serviceProvidedDTO.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idClient = serviceProvidedDTO.getIdClient();

        // Returns a Optional - means that return a interface that can include or not a Client
        Client client = clientRepository
                            .findById(idClient)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found"));

        ServiceProvided serviceProvided = new ServiceProvided();
        serviceProvided.setDescription(serviceProvidedDTO.getDescription());
        serviceProvided.setDate(date);
        serviceProvided.setClient(client);
        serviceProvided.setPrice(bigDecimalConvertion.convert(serviceProvidedDTO.getPrice()));

        return serviceProvidedRepository.save(serviceProvided);
    }

}
