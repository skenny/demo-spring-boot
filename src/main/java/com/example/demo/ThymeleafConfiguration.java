package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfiguration {

	/**
	 * Enables layout dialect
	 * 
	 * https://github.com/ultraq/thymeleaf-layout-dialect
	 */
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}
