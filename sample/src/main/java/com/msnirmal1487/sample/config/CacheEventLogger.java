package com.msnirmal1487.sample.config;

import org.ehcache.event.CacheEventListener;

import org.ehcache.event.CacheEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {
	private static final Logger LOG = LoggerFactory.getLogger(CacheEventLogger.class);
	
	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		LOG.info("Key: {} | EventType: {} ",
                cacheEvent.getKey(), cacheEvent.getType());
	}
}
