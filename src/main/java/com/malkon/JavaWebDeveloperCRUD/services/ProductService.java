package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

	public Product find(String code) {
		Optional<Product> product = productRepository.findByCode(code);
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

	public Product update(ProductDto productDto, String code) {
		Product newProduct = find(code);
		updateData(newProduct, productDto);
		return productRepository.save(newProduct);
	}

	public void delete(String code) {
		find(code);
		try {
			productRepository.deleteByCode(code);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Não foi possível excluir o produto", e);
		}
	}

	private void updateData(Product newProduct, ProductDto productDto) {
		newProduct.setCode(productDto.getCode());
		newProduct.setDescription(productDto.getDescription());
		Department department = departmentRepository.findByName(productDto.getDepartment());
		newProduct.getDepartments().addAll(Arrays.asList(department));
		newProduct.setPrice(productDto.getPrice());
		newProduct.setStatus(productDto.getStatus());
	}

}
