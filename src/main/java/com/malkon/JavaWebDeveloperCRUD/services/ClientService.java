package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client find(UUID id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow();

	}

	public Client insert(Client client) {
		client.setId(null);
		return clientRepository.save(client);
	}

	public Client update(Client client) {
		Client newClient = find(client.getId());
		updateData(newClient, client);
		return clientRepository.save(newClient);
	}

	private void updateData(Client newClient, Client client) {
		newClient.setName(client.getName());
	}

}
