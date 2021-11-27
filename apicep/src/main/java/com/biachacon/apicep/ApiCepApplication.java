package com.biachacon.apicep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCepApplication {
	private static final Logger Logger = LoggerFactory.getLogger(ApiCepApplication.class);

	public static void main(String[] args) {
		Logger.info("Iniciando API para busca de CEP");
		SpringApplication.run(ApiCepApplication.class, args);
		Logger.info("API para busca de CEP iniciada");
	}

}
