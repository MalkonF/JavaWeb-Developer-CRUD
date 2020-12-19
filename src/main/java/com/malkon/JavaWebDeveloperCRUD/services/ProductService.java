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

	
	private String b;
	public List<ProductDto> findAll() {
		List<ProductDto> productDtoList = new ArrayList<>();
		List<Product> listProduct = productRepository.findAll();
		for (Product product : listProduct) {
			// System.out.println("debug:"+product.getDepartments().toString());
			List<Department> productDepartment = product.getDepartments();
			
			for (Department department : productDepartment) 
				b = department.getName();

			ProductDto productDto = new ProductDto(product.getCode(), product.getDescription(), b,
					product.getPrice(), product.getStatus());
			System.out.println(productDto.getDepartment());
			productDtoList.add(productDto);
			//productDto.clear();
	
		}
		return productDtoList;
	}

	public Product find(UUID code) {
		Optional<Product> product = productRepository.findById(code);
		return product.orElseThrow();
	}

	public Product insert(ProductDto productDto) {
		// product.setId(null);
		// debug purpose System.out.println(product.getDepartments());
		Product product = new Product(null, productDto.getCode(), productDto.getDescription(), productDto.getPrice(),
				productDto.getStatus());
		Department department = departmentRepository.findByName(productDto.getDepartment());
		// System.out.println("debug"+productDto.getDepartment());
		product.getDepartments().addAll(Arrays.asList(department));
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
