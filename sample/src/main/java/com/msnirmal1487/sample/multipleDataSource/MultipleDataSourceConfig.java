package com.msnirmal1487.sample.multipleDataSource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultipleDataSourceConfig {

	@Primary
	@Bean(name = "firstDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.first-source")
	public DataSource firstDataSource() {
	return DataSourceBuilder.create().build();
	}
}
