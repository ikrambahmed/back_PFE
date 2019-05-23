package application.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class webConfig {
	@Bean(name = "mission")
	 @ConfigurationProperties(prefix = "spring.datasource")
	 public DataSource dataSource() {
	 //return DataSourceBuilder.create().build();
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/mission");
	    dataSource.setUsername("mission");
	    dataSource.setPassword("mission");

	    return dataSource;


		
		
	 }
	 @Bean(name = "jdbcTemplate")
	 public JdbcTemplate jdbcTemplate(@Qualifier("mission") DataSource ds) {
	  return new JdbcTemplate(ds);
	 }}
