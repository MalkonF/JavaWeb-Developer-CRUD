package com.malkon.JavaWebDeveloperCRUD.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClientTest {

	@Test
	public void clientTestAtributes() {
		Client client = new Client(null, null, "Linus Torvalds");
		assertEquals("Linus Torvalds", client.getName());
		assertTrue(client.getName().equalsIgnoreCase("LinUS TorvaldS"));
	}

}
