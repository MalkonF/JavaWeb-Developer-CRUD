package com.malkon.JavaWebDeveloperCRUD.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

	Product findProductByDescription(String description);

	List<Product> findAll();

	Optional<Product> findById(UUID id);
	
	
	@Transactional
	void deleteByCode(UUID id);

}
