package com.msnirmal1487.sample.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.msnirmal1487.sample.service.BookService;

@Component
public class ScheduledJobByProfile {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledJobByProfile.class);
	@Autowired
	private BookService service;
	
	@Scheduled(cron = "0 */1 22 * * ?")
	@Profile("cron_job")
	public void cronJob() {
		LOG.info("Running the scheduled job at " + new Date());
		LOG.info(service.findById(1231).toString());
	}
	
}
