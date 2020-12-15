package com.malkon.JavaWebDeveloperCRUD.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

	Department findDepartmentByName(String name);
	
	List<Department> findAll();

}
