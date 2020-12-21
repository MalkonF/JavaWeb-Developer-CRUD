package com.malkon.JavaWebDeveloperCRUD.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.domain.dto.ProductDto;
import com.malkon.JavaWebDeveloperCRUD.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> findAll() {
		List<ProductDto> listProductDto = productService.findAll();
		return ResponseEntity.ok().body(listProductDto);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable UUID id) {
		Product product = productService.find(id);
		return ResponseEntity.ok().body(product);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> insert(@RequestBody ProductDto productDto) {
		Product product = productService.insert(productDto);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(product.getCode())
				//.toUri();
		return ResponseEntity.ok().body(product);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ProductDto productDto, @PathVariable UUID id) {
		productDto.setCode(productDto.getCode());
		Product product = productService.update(productDto, id);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
