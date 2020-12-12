package com.malkon.JavaWebDeveloperCRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malkon.JavaWebDeveloperCRUD.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
