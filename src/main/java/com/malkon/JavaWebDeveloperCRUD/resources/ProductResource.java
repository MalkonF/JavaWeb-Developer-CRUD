package com.malkon.JavaWebDeveloperCRUD.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.malkon.JavaWebDeveloperCRUD.domain.Product;

public class ProductResource {

	public ResponseEntity<Product> find(@PathVariable String code) {

		return null;

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
