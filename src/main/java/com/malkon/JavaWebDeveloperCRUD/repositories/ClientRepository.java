package com.malkon.JavaWebDeveloperCRUD.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

	Client findUserByName(String string);

}
