package com.myapp.appointmentsystem.service;

import com.myapp.appointmentsystem.model.Client;
import com.myapp.appointmentsystem.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ClientService {
	
	private final ClientRepository repository;
	
	public ClientService (ClientRepository repository) {
		this.repository=repository;
	}
	
	public List<Client> getAllClients(){
		return repository.findAll();
	}
	
	public Client getClientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    public Client createClient(Client client) {
        return repository.save(client);
    }

    public void deleteClient(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        repository.deleteById(id);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());

        return repository.save(existingClient);
    }
}
