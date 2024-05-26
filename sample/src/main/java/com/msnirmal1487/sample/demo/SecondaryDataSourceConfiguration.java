package com.msnirmal1487.sample.demo;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondaryDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("spring.datasource.demo")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.demo.hikari")
	public DataSource secondaryDataSource() {
		return secondaryDataSourceProperties()
				.initializeDataSourceBuilder()
				.build();
	}
}
