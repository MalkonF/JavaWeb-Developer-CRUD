package com.malkon.JavaWebDeveloperCRUD.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable UUID id) {

		Product obj = productService.find(id);

		return ResponseEntity.ok().body(obj);

	}

	public ResponseEntity<Void> insert(Product product) {

		return null;
	}

	public ResponseEntity<Void> update(Product product, String code) {

		return null;
	}

	public ResponseEntity<Void> delete(String code) {

		return null;
	}
}
