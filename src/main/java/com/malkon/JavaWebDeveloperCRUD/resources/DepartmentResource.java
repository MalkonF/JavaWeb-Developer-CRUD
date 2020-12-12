package com.malkon.JavaWebDeveloperCRUD.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentResource {
	
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Department> find(@PathVariable UUID id) {

		Department obj = departmentService.find(id);

		return ResponseEntity.ok().body(obj);

	}

	public ResponseEntity<Void> insert(Department department) {

		return null;
	}

	public ResponseEntity<Void> update(Department department, Integer code) {

		return null;
	}

	public ResponseEntity<Void> delete(Integer code) {

		return null;
	}
}
