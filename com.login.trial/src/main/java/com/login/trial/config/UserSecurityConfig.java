package com.login.trial.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan("com.login.trial")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class UserSecurityConfig {

	@Autowired
	public Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			securityDataSource.setDriverClass("com.mysql.jdbc.Driver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// for sanity's sake, let's log url and user ... just to make sure we are reading the data
		logger.info("jdbc.url=" + env.getProperty("jdbc.url2"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url2"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));		
		securityDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return securityDataSource;
	}
	
}
