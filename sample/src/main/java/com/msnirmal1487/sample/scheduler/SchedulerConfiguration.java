package com.msnirmal1487.sample.scheduler;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;

import net.javacrumbs.shedlock.core.LockProvider;
//import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;

@Configuration
public class SchedulerConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(SchedulerConfiguration.class);
	
//	@Qualifier("firstDataSource")
//	private DataSource firstDataSource;
//	
//    @Bean
//    public LockProvider lockProvider(DataSource dataSource) {
//        return new JdbcTemplateLockProvider(firstDataSource);
//    }
    
    @Value("${spring.data.mongodb.sched-database}")
//    @Value("${spring.data.mongodb.database}")
    private String database;
    
    @Bean
    public LockProvider lockProvider(MongoClient mongo) {
        LOG.debug("Database name for Scheduler Lock {} : ", database);
        return new MongoLockProvider(mongo.getDatabase(database));
    }
}