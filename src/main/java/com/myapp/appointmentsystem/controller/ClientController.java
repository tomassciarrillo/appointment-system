package com.myapp.appointmentsystem.controller;

import com.myapp.appointmentsystem.model.Client;
import com.myapp.appointmentsystem.service.ClientService;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientService service;
	
	public ClientController(ClientService service) {
		this.service=service;
	}
	
	@GetMapping
	public List<Client> getAllClients() {
		return service.getAllClients();
	}
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable Long id) {
		return service.getClientById(id);
	}
	
	@PostMapping
	public Client createClient(@Valid @RequestBody Client client) {
		return service.createClient(client);
	}
	
	@PutMapping("/{id}")
	public Client updateClient(@PathVariable Long id, @Valid @RequestBody Client updatedClient) {
		return service.updateClient(id, updatedClient);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		service.deleteClient(id);
	}
	
	
}
