package com.docconcierge.dep_filial_service;

import com.docconcierge.dep_filial_service.repository.DepartamentoRepository;
import com.docconcierge.dep_filial_service.repository.FilialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DepFilialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepFilialServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FilialRepository filialRepository, DepartamentoRepository departamentoRepository) {
		return args -> {

		};
	}
}
