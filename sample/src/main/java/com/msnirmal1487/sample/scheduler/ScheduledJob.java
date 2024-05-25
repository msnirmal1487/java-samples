package com.msnirmal1487.sample.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.msnirmal1487.sample.service.BookService;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Component
public class ScheduledJob {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledJob.class);
	
	@Autowired
	private BookService service;
	
	//Spring, by default, cannot handle scheduler synchronization over multiple instances. 
	//	It executes the jobs simultaneously on every node instead.
	//	ShedLock — a Java library that makes sure our scheduled tasks run only once 
	// at the same time and is an alternative to Quartz.
	
	//	https://www.baeldung.com/shedlock-spring
	// the schedlock table DDL available in resources/schema.sql
	
	@Scheduled(cron = "0 */2 22 * * ?")
	@net.javacrumbs.shedlock.spring.annotation.SchedulerLock(name = "ScheduledJob_cronJob", 
		      lockAtLeastFor = "PT1M", lockAtMostFor = "PT14M")
	public void cronJob() {
		LOG.info("Running the scheduled job at " + new Date());
		LOG.info(service.findById(123).toString());
	}
}
