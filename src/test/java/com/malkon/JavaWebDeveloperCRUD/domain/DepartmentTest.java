package com.malkon.JavaWebDeveloperCRUD.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DepartmentTest {

	@Test
	public void departmentTestAtributes() {
		Department department = new Department(null, 45, "Alimentos");
		assertEquals(45, department.getCode());
		assertEquals("Alimentos", department.getName());
	}

}
