package com.malkon.JavaWebDeveloperCRUD.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {

	@Test
	public void productTestAtributes() {
		Product product = new Product(null, "45de", "Tv LG 48 pol", 1340.99, true);
		assertEquals("45de", product.getCode());
		assertEquals("Tv LG 48 pol", product.getDescription());
		assertEquals(1340.99, product.getPrice());
		assertEquals(true, product.getStatus());
	}

}
