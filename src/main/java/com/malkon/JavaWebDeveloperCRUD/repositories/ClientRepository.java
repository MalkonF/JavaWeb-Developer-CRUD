package com.malkon.JavaWebDeveloperCRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
