package com.malkon.JavaWebDeveloperCRUD.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void insert() {
		Department department = new Department(null, 12, "Laticinios");
		departmentRepository.save(department);
		Integer countDepartment = departmentRepository.findAll().size();
		assertEquals(1, countDepartment - 9); // 9 departments foram instanciados para popular a base de dados
	}

	@Test
	public void checkDepartmentSavedNotNull() {
		Department department = new Department(null, 15, "Cama mesa e banho");
		departmentRepository.save(department);
		Integer countDepartment = departmentRepository.findAll().size();
		assertEquals(1, countDepartment - 9);
		Department department1 = departmentRepository.findByName("Cama mesa e banho");
		assertNotNull(department1);
		assertEquals(department, department1);
	}

	@Test
	public void checkDepartmentNotExistShouldReturnNull() {
		Department department = new Department(null, 40, "Laticinio");
		departmentRepository.save(department);
		Integer countDepartment = departmentRepository.findAll().size();
		assertEquals(1, countDepartment - 9);
		Department department1 = departmentRepository.findByName("Frutas");
		assertNull(department1);
	}

}
