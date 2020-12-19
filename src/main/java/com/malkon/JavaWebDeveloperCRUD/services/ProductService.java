package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.domain.dto.ProductDto;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;
import com.malkon.JavaWebDeveloperCRUD.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	private String departmentName;

	public List<ProductDto> findAll() {
		List<ProductDto> productDtoList = new ArrayList<>();
		List<Product> listProduct = productRepository.findAll();
		for (Product product : listProduct) {
			// System.out.println("debug:"+product.getDepartments().toString());
			List<Department> productDepartment = product.getDepartments();
			for (Department department : productDepartment)
				departmentName = department.getName();
			ProductDto productDto = new ProductDto(product.getCode(), product.getDescription(), departmentName,
					product.getPrice(), product.getStatus());
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	public Product find(UUID code) {
		Optional<Product> product = productRepository.findById(code);
		return product.orElseThrow();
	}

	public Product insert(ProductDto productDto) {
		Product product = new Product(null, productDto.getCode(), productDto.getDescription(), productDto.getPrice(),
				productDto.getStatus());
		try {
		Department department = departmentRepository.findByName(productDto.getDepartment());
		product.getDepartments().addAll(Arrays.asList(department));
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Não foi possível inserir o produto porque não existe esta categoria.");
		}
		departmentRepository.saveAll(product.getDepartments());
		return productRepository.save(product);
	}

	public Product update(Product product) {
		Product newProduct = find(product.getId());
		updateData(newProduct, product);
		return productRepository.save(newProduct);
	}

	public void delete(UUID id) {
		find(id);
		try {
			productRepository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não foi possível excluir o produto", e);
		}
	}

	private void updateData(Product newProduct, Product product) {
		newProduct.setCode(product.getCode());
		newProduct.setDescription(product.getDescription());
		newProduct.setPrice(product.getPrice());
		newProduct.setStatus(product.getStatus());
	}

}
