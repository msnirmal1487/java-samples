package com.msnirmal1487.sample.demo;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Category.class, entityManagerFactoryRef = "demoEntityManagerFactory", transactionManagerRef = "demoTransactionManager")
public class DemoJpaConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean demoEntityManagerFactory(
			@Qualifier("secondaryDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages(Category.class).build();
	}

	@Bean
	public PlatformTransactionManager demoTransactionManager(
			@Qualifier("demoEntityManagerFactory") LocalContainerEntityManagerFactoryBean demoEntityManagerFactory) {
		return new JpaTransactionManager(Objects.requireNonNull(demoEntityManagerFactory.getObject()));
	}
}
