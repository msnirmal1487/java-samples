package com.msnirmal1487.sample.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcService {

	final static Logger LOG = LoggerFactory.getLogger(JdbcService.class);
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate schedJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	JdbcTemplate demoJdbcTemplate;

	public Connection getPrimaryConnection() throws SQLException {

		LocalDateTime start = LocalDateTime.now();
		Connection conn = null;

		try {
			conn = schedJdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("getPrimaryConnection : Failed to make database connection", e);
		}

		LocalDateTime end = LocalDateTime.now();
		LOG.info("***** getPrimaryConnection in MS: " + Duration.between(start, end).toMillis());
		return conn;
	}

	public Connection getSecondaryConnection() throws SQLException {

		LocalDateTime start = LocalDateTime.now();
		Connection conn = null;

		try {
			conn = demoJdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("getSecondaryConnection : Failed to make database connection", e);
		}

		LocalDateTime end = LocalDateTime.now();
		LOG.info("***** getSecondaryConnection in MS: " + Duration.between(start, end).toMillis());
		return conn;
	}
	
	public List<Long> getDepartmentIds(){
		
		String query = "select department_id from department";
        ResultSet rs;
        List<Long> deptIds = new ArrayList<>();
        
        try (Connection conn = getPrimaryConnection();
        		CallableStatement stmt = conn.prepareCall(query)){
        	rs = stmt.executeQuery();
        	
        	while(rs.next()) {
        		deptIds.add(rs.getLong(1));
        	}
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return deptIds;
	}
	
public List<Long> getCategoryIds(){
		
		String query = "select category_id from category";
        ResultSet rs;
        List<Long> categIds = new ArrayList<>();
        
        try (Connection conn = getSecondaryConnection();
        		CallableStatement stmt = conn.prepareCall(query)){
        	rs = stmt.executeQuery();
        	
        	while(rs.next()) {
        		categIds.add(rs.getLong(1));
        	}
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return categIds;
	}

}
