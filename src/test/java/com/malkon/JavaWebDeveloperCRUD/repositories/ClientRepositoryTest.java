package com.malkon.JavaWebDeveloperCRUD.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void insert() {
		Client client = new Client(null, null, "Maradona");
		clientRepository.save(client);
		Integer countClient = clientRepository.findAll().size();
		assertEquals(1, countClient - 6); // 6 usuários foram instanciados para popular a base de dados
	}

	@Test
	public void checkClientSavedNotNull() {
		Client client = new Client(null, null, "Chaves");
		clientRepository.save(client);
		Integer countClient = clientRepository.findAll().size();
		assertEquals(1, countClient - 6);
		Client client1 = clientRepository.findClientByName("Chaves");
		assertNotNull(client1);
		assertEquals(client, client1);
	}

	@Test
	public void checkClientNotExistShouldReturnNull() {
		Client client = new Client(null, null, "Seu madruga");
		clientRepository.save(client);
		Integer countClient = clientRepository.findAll().size();
		assertEquals(1, countClient - 6);
		Client client1 = clientRepository.findClientByName("Girafales");
		assertNull(client1);
	}

}
