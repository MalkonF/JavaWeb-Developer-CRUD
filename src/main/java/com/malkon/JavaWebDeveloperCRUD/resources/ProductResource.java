package com.malkon.JavaWebDeveloperCRUD.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable String code) {
		Product product = productService.find(code);
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
	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ProductDto productDto, @PathVariable String code) {
		//productDto.setCode(code);
		Product product = productService.update(productDto, code);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String code) {
		productService.delete(code);
		return ResponseEntity.noContent().build();
	}

}
