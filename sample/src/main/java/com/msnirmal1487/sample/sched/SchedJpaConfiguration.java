package com.msnirmal1487.sample.sched;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Department.class, entityManagerFactoryRef = "schedEntityManagerFactory", transactionManagerRef = "schedTransactionManager")
public class SchedJpaConfiguration {

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean schedEntityManagerFactory(
			@Qualifier("primaryDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages(Department.class).build();
	}

	@Bean
	public PlatformTransactionManager schedTransactionManager(
			@Qualifier("schedEntityManagerFactory") LocalContainerEntityManagerFactoryBean schedEntityManagerFactory) {
		return new JpaTransactionManager(Objects.requireNonNull(schedEntityManagerFactory.getObject()));
	}
}
