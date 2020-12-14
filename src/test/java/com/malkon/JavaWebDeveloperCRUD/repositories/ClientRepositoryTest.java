package com.malkon.JavaWebDeveloperCRUD.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(1, countClient - 6); //6 usuários foram instanciados para popular a base de dados
	}

}
