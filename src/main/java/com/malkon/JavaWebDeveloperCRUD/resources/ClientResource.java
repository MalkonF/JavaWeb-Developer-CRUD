package com.malkon.JavaWebDeveloperCRUD.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService clientService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAll() {
		List<Client> listClients = clientService.findAll();
		return ResponseEntity.ok().body(listClients);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> find(@PathVariable UUID id) {
		Client client = clientService.find(id);
		return ResponseEntity.ok().body(client);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Client client) {
		client.setCode(UUID.randomUUID());
		client = clientService.insert(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Client client, @PathVariable UUID id) {
		client.setId(id);
		client = clientService.update(client);
		return ResponseEntity.noContent().build();// nocontent retorna conteúdo vazio
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
