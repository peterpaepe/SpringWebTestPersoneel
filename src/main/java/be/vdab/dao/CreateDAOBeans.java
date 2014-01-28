package be.vdab.dao;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("be.vdab.dao")//Je geeft aan dat Spring één bean moet maken per class met de annotation @Repository in de package be.vdab.dao
@PropertySource("classpath:/database.properties")
public class CreateDAOBeans {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close")
	ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(environment.getProperty("database.driverClass"));
			dataSource.setJdbcUrl(environment.getProperty("database.jdbcUrl"));
			dataSource.setUser(environment.getProperty("database.user"));
			dataSource.setPassword(environment.getProperty("database.password"));
			dataSource.setMaxIdleTime(environment.getProperty("database.maxIdleTime", Integer.class));
		} catch (Exception ex) {
			logger.severe("invalid C3P0 properties:" + ex.getMessage());
		}
		return dataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	NamedParameterJdbcTemplate namedJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}