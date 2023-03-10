package com.salesianos.triana.ComiendoPorTriana;

import com.salesianos.triana.ComiendoPorTriana.files.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComiendoPorTrianaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComiendoPorTrianaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}
