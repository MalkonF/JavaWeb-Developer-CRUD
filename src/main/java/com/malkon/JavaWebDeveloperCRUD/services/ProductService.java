package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;
import com.malkon.JavaWebDeveloperCRUD.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public Product find(UUID code) {
		Optional<Product> obj = productRepository.findById(code);
		return obj.orElseThrow();
	}

	public Product insert(Product product) {
		product.setId(null);
		// debug purpose System.out.println(product.getDepartments());
		departmentRepository.saveAll(product.getDepartments());
		return productRepository.save(product);
	}

	public Product update(Product product) {
		Product newProduct = find(product.getId());
		updateData(newProduct, product);
		return productRepository.save(newProduct);
	}

	private void updateData(Product newProduct, Product product) {
		newProduct.setCode(product.getCode());
		newProduct.setDescription(product.getDescription());
		newProduct.setPrice(product.getPrice());
		newProduct.setStatus(product.getStatus());
	}

}
