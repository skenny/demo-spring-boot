package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;

@Configuration
public class DatabaseConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "datasource.postgres")
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public EbeanServer ebeanServer(DataSource datasource) {
		ServerConfig config = new ServerConfig();
		config.setName("ebeanServer");
		config.setDataSource(datasource);
		config.addPackage("com.example.demo.model");
		config.setExpressionNativeIlike(true);
		//config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());
		
		return EbeanServerFactory.create(config);
	}

}
