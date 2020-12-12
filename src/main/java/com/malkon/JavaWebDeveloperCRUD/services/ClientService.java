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

}
