package com.malkon.JavaWebDeveloperCRUD.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malkon.JavaWebDeveloperCRUD.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

	Product findProductByDescription(String description);

}
