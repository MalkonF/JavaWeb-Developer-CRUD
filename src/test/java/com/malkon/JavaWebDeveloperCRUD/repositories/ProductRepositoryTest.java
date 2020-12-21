package com.malkon.JavaWebDeveloperCRUD.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void insert() {
		Product product = new Product(null, "Y79", "Oculos RayBan", 333.99, true);
		productRepository.save(product);
		Integer countProduct = productRepository.findAll().size();
		assertEquals(1, countProduct - 12); // 12 Products foram instanciados para popular a base de dados
	}

	@Test
	public void checkProductSavedNotNull() {
		Product product = new Product(null, "TTG6", "Camiseta polo fibra", 65.90, true);
		productRepository.save(product);
		Integer countProduct = productRepository.findAll().size();
		assertEquals(1, countProduct - 12);
		Product product1 = productRepository.findProductByDescription("Camiseta polo fibra");
		assertNotNull(product1);
		assertEquals(product, product1);
	}

	@Test
	public void checkProductNotExistShouldReturnNull() {
		Product product = new Product(null, "QQU", "Quadro Sala Modernista", 120.0, true);
		productRepository.save(product);
		Integer countProduct = productRepository.findAll().size();
		assertEquals(1, countProduct - 12);
		Product product1 = productRepository.findProductByDescription("Meia Socks Algodao");
		assertNull(product1);
	}

}
