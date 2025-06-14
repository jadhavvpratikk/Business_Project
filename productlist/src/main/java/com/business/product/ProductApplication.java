package com.business.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API documentation",
				description = "Product service REST API",
				version = "v1",
				contact = @Contact(
						name = "Pratik Jadhav",
						email = "jadhavvpratikk96@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Share drive access",
				url = "https://www.google.com/"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);

	}

}
