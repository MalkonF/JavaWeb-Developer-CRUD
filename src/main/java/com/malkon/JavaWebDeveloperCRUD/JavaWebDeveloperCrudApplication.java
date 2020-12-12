package com.malkon.JavaWebDeveloperCRUD;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.malkon.JavaWebDeveloperCRUD.domain.Client;
import com.malkon.JavaWebDeveloperCRUD.domain.Department;
import com.malkon.JavaWebDeveloperCRUD.domain.Product;
import com.malkon.JavaWebDeveloperCRUD.repositories.DepartmentRepository;
import com.malkon.JavaWebDeveloperCRUD.repositories.ProductRepository;

@SpringBootApplication
public class JavaWebDeveloperCrudApplication implements CommandLineRunner {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaWebDeveloperCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department dep1 = new Department(null, 1, "Alimentos e Bebidas");
		Department dep2 = new Department(null, 2, "Apps e Jogos");
		Department dep3 = new Department(null, 3, "Automotivo");
		Department dep4 = new Department(null, 4, "Bebês");
		Department dep5 = new Department(null, 5, "Beleza");
		Department dep6 = new Department(null, 6, "Brinquedos e Jogos");
		Department dep7 = new Department(null, 7, "Eletrodomésticos");
		Department dep8 = new Department(null, 8, "Eletrônicos");
		Department dep9 = new Department(null, 9, "Outros");

		Product prod1 = new Product(null, "12", "iPhone 11 Apple com 128GB, Tela Retina HD de 6,1", 4699.0, true);
		Product prod2 = new Product(null, "35", "Monitor Widescreen LCD LED 18.5” AOC HD E970SWNL", 444.9, true);
		Product prod3 = new Product(null, "312800A", "Fogão 3 Bocas 1 Dupla Cristalaço Industrial Baixa Pressão",
				718.08, true);
		Product prod4 = new Product(null, "478ZB", "Fone de Ouvido Apple AirPods 2 com Estojo de Recarga", 10.99, true);
		Product prod5 = new Product(null, "114523KL", "Galaxy S20 Ultra Cosmic Gray 128GB", 6029.1, true);
		Product prod6 = new Product(null, "55bL", "Cerveja Antartica Lt", 2.99, true);
		Product prod7 = new Product(null, "765J", "Console Paystation 5", 4.699, true);
		Product prod8 = new Product(null, "88ui", "SONAX BRILLIANTSHINE DETAILER", 89.99, true);
		Product prod9 = new Product(null, "EE10", "Fralda Pompers", 45.99, true);
		Product prod10 = new Product(null, "FJX7", "Batom Femina Lance", 60.99, true);
		Product prod11 = new Product(null, "KK90", "Jogo de Xadrez OMNI CLASS", 39.89, true);
		Product prod12 = new Product(null, "KK90", "Fita adesiva DUREX", 6.29, true);

		Client cli1 = new Client(null, null, "Kegyu Guida");
		Client cli2 = new Client(null, null, "Miohu Daein");
		Client cli3 = new Client(null, null, "Kauvi Hifio");
		Client cli4 = new Client(null, null, "Befey Saoen");
		Client cli5 = new Client(null, null, "Lyeko Ceotirun");
		Client cli6 = new Client(null, null, "Mebol Morui");

		dep1.getProducts().addAll(Arrays.asList(prod6));
		dep2.getProducts().addAll(Arrays.asList(prod7));
		dep3.getProducts().addAll(Arrays.asList(prod8));
		dep4.getProducts().addAll(Arrays.asList(prod9));
		dep5.getProducts().addAll(Arrays.asList(prod10));
		dep6.getProducts().addAll(Arrays.asList(prod11));
		dep7.getProducts().addAll(Arrays.asList(prod3));
		dep8.getProducts().addAll(Arrays.asList(prod1, prod2, prod4, prod5));
		dep9.getProducts().addAll(Arrays.asList(prod12));

		prod1.getDepartments().addAll(Arrays.asList(dep8));
		prod2.getDepartments().addAll(Arrays.asList(dep8));
		prod3.getDepartments().addAll(Arrays.asList(dep7));
		prod4.getDepartments().addAll(Arrays.asList(dep8));
		prod5.getDepartments().addAll(Arrays.asList(dep8));
		prod6.getDepartments().addAll(Arrays.asList(dep1));
		prod7.getDepartments().addAll(Arrays.asList(dep2));
		prod8.getDepartments().addAll(Arrays.asList(dep3));
		prod9.getDepartments().addAll(Arrays.asList(dep4));
		prod10.getDepartments().addAll(Arrays.asList(dep5));
		prod11.getDepartments().addAll(Arrays.asList(dep6));
		prod12.getDepartments().addAll(Arrays.asList(dep9));

		departmentRepository.saveAll(Arrays.asList(dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8, dep9));
		productRepository.saveAll(
				Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11, prod12));

	}

}
