package com.ProdProject.ProdPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ProdProject.ProdPro.Modals")
public class ProdProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdProApplication.class, args);
	}

}
