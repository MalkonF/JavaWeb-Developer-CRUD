package com.malkon.JavaWebDeveloperCRUD.resources;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;
import com.malkon.JavaWebDeveloperCRUD.services.DepartmentService;

@WebMvcTest(controllers = DepartmentResource.class)
@ContextConfiguration(classes = DepartmentService.class)
@Import(DepartmentResource.class)
public class DepartmentResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentRepository departmentRepository;

	@Test
	public void findAllDepartment() throws Exception {
		Department department = new Department(UUID.randomUUID(), 33, "Vestuario");
		List<Department> departmentList = List.of(department);
		when(departmentRepository.findAll()).thenReturn(departmentList);
		mockMvc.perform(get("/departments")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Vestuario")));
	}

}
