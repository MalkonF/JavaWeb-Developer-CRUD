package com.malkon.JavaWebDeveloperCRUD.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.services.DepartmentService;

@Component
public class DepartmentSchedule {
	
	@Autowired
	DepartmentService departmentService;

	private final long SECONDS = 15;
	
	@Scheduled(fixedDelay = SECONDS) 
    public void verifyDepartmentPerSeconds() { 
        RestTemplate restTemplate = new RestTemplate();
        Department department = restTemplate.getForObject("https://private-anon-0b6825f1d3-maximatech.apiary-mock.com/fullstack/departamento", Department.class);
        departmentService.update(department);
	}

}
