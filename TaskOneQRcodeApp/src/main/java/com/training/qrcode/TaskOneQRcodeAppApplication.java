package com.training.qrcode;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TaskOneQRcodeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskOneQRcodeAppApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.training"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"QR Code Generator API",
				"Task One of the training",
				"1.0",
				"aaaaaaaaaaaa",
				new Contact("Aswanth Asokan","", "aswanthaagmail.com"),
				"API License",
				"",
				java.util.Collections.emptyList()
				
				);
		
	}
}
