package com.msnirmal1487.sample.sched;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PrimaryDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("spring.datasource.sched")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.sched.hikari")
	public DataSource primaryDataSource() {
		return primaryDataSourceProperties()
				.initializeDataSourceBuilder()
				.build();
	}
	
	@Bean
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
