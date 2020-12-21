package com.malkon.JavaWebDeveloperCRUD.domain.dto;

import java.io.Serializable;
import java.util.UUID;

public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String code;
	private String description;
	private String department;
	private Double price;
	private Boolean status;

	public ProductDto() {
	}

	public ProductDto(UUID id, String code, String description, String department, Double price, Boolean status) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.department = department;
		this.price = price;
		this.status = status;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
