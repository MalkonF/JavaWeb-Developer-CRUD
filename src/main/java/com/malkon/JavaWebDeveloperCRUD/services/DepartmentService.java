package com.malkon.JavaWebDeveloperCRUD.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		List<Department> listDepartment = departmentRepository.findAll();
		return listDepartment;
	}

	public Department find(UUID id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department.orElseThrow();
	}

	public Department insert(Department department) {
		department.setId(null);
		return departmentRepository.save(department);
	}

	public Department update(Department department) {
		Department newDepartment = find(department.getId());
		updateData(newDepartment, department);
		return departmentRepository.save(newDepartment);
	}

	public void delete(UUID id) {
		find(id);
		try {
			departmentRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Não é possível excluir um departamento que contém produtos associados", e);
		}
	}

	private void updateData(Department newDepartment, Department department) {
		newDepartment.setName(department.getName());
	}

}
