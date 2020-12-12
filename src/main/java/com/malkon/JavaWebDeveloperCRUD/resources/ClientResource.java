package com.malkon.JavaWebDeveloperCRUD.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> find(@PathVariable UUID id) {

		Client obj = clientService.find(id);

		return ResponseEntity.ok().body(obj);

	}

	public ResponseEntity<Void> insert(Client client) {

		return null;
	}

	public ResponseEntity<Void> update(Client client, UUID code) {

		return null;
	}

	public ResponseEntity<Void> delete(UUID code) {

		return null;
	}

}
