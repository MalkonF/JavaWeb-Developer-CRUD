package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product find(UUID code) {
		Optional<Product> obj = productRepository.findById(code);
		return obj.orElseThrow();

	}

	public Product insert(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}

}
