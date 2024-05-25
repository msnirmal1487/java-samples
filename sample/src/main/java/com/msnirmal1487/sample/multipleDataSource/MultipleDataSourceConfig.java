package com.msnirmal1487.sample.multipleDataSource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

//@Configuration
public class MultipleDataSourceConfig {

	@Primary
	@Bean(name = "primaryDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource-primary")
	public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }
	
	 @Primary
	    @Bean(name = "primaryDataSource")
	    @ConfigurationProperties("spring.datasource-primary.configuration")
	    public DataSource primaryDataSource(@Qualifier("primaryDataSourceProperties") DataSourceProperties primaryDataSourceProperties) {
	        return primaryDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	    }
	 
//	 @Primary
//	    @Bean(name = "primaryEntityManagerFactory")
//	    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
//	            EntityManagerFactoryBuilder primaryEntityManagerFactoryBuilder, @Qualifier("primaryDataSource") DataSource primaryDataSource) {
//
//	        Map<String, String> primaryJpaProperties = new HashMap<>();
//	        primaryJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//	        primaryJpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
//
//	        return primaryEntityManagerFactoryBuilder
//	                .withDataSource(primaryDataSource)
//	                .packages("com.msnirmal1487.sample.model.primary")
//	                .persistenceUnit("primaryDataSource")
//	                .properties(primaryJpaProperties)
//	                .build();
//	    }

	    @Primary
	    @Bean(name = "primaryTransactionManager")
	    public PlatformTransactionManager primaryTransactionManager(
	            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {

	        return new JpaTransactionManager(primaryEntityManagerFactory);
	    }
}
