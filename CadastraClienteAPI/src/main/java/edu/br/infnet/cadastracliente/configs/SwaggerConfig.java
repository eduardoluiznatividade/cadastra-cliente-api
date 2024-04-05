package edu.br.infnet.cadastracliente.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@RestController
public class SwaggerConfig {

	@Bean
	public OpenAPI customAPI() {
		
		return new OpenAPI().info(new Info().title("Swagger Cadastra Cliente API").version("1.0.0"));
	}
	
	
	
	
}
