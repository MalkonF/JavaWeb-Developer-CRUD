package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client find(UUID id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow();

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

	public void delete(UUID id) {
		find(id);
		try {
			clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível excluir o cliente ", e);
		}
	}

	private void updateData(Client newClient, Client client) {
		newClient.setName(client.getName());
	}

	public List<Client> findAll() {
		List<Client> listClient = clientRepository.findAll();
		return listClient;
	}

}
