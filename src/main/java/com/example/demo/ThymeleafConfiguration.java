package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfiguration {

	/**
	 * Enables layout dialect.
	 * 
	 * https://github.com/ultraq/thymeleaf-layout-dialect
	 */
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	/**
	 * Enables spring-security extras.
	 * 
	 * https://github.com/thymeleaf/thymeleaf-extras-springsecurity
	 */
	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}

}
