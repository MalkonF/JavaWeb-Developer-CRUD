package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department find(UUID id) {
		Optional<Department> obj = departmentRepository.findById(id);
		return obj.orElseThrow();

	}

}
