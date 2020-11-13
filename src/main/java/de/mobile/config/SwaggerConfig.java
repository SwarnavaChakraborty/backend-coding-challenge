package de.mobile.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger UI2 Config for Documenting the API
 * 
 * @author SWCHAKR
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(Collection.class, Instant.class),
						typeResolver.resolve(Collection.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
				.select().apis(RequestHandlerSelectors.basePackage("de.mobile.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Mobile.de Microservice REST API", "Mobile.de Microservice REST API", "1.0",
				"Terms of service", new Contact("Mobile.de", "https://www.mobile.de/", "admin@mobile-de.com"),
				"Mobile.de Licence version 1.0", "https://www.mobile.de/licenses/LICENSE-2.0", new ArrayList<>());
	}
}
