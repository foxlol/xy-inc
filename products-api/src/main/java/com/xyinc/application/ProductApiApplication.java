package com.xyinc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configurações da aplicação Spring.
 * 
 * @author diogenes.feijo
 *
 */
@SpringBootApplication
@ComponentScan("com.xyinc")
@EntityScan("com.xyinc.model")
@EnableJpaRepositories("com.xyinc.repository")
public class ProductApiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProductApiApplication.class, args);
	}
	
}
