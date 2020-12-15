package com.malkon.JavaWebDeveloperCRUD.resources;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.repositories.ClientRepository;
import com.malkon.JavaWebDeveloperCRUD.services.ClientService;


@WebMvcTest(controllers = ClientResource.class)
@ContextConfiguration(classes = ClientService.class)
@Import(ClientResource.class)
public class ClientResourceTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ClientRepository clientRepository;

	@Test
	public void findAllClients() throws Exception {
		Client client = new Client(UUID.randomUUID(), UUID.randomUUID(), "Bruce Wayne");
		List<Client> clientList = List.of(client);
		when(clientRepository.findAll()).thenReturn(clientList);
		mockMvc.perform(get("/clients")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Bruce Wayne")));
	}

}
