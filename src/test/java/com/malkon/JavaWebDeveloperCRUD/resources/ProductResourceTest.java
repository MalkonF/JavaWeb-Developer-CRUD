package com.malkon.JavaWebDeveloperCRUD.resources;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;
import com.malkon.JavaWebDeveloperCRUD.repositories.ProductRepository;
import com.malkon.JavaWebDeveloperCRUD.services.ProductService;

@WebMvcTest(controllers = ProductResource.class)
@ContextConfiguration(classes = ProductService.class)
@Import(ProductResource.class)
public class ProductResourceTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductRepository productRepository;

	@MockBean
	private DepartmentRepository departmentRepository;

	@Test
	public void findAllProducts() throws Exception {
		Product product = new Product(UUID.randomUUID(), "33E", "Pilha Alcalina Palito", 19.90, true);
		List<Product> productList = List.of(product);
		when(productRepository.findAll()).thenReturn(productList);
		mockMvc.perform(get("/products")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Pilha Alcalina Palito")));
	}

}
