package net.ashish.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = { "net.ashish.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	/*
	 * Change the below based on the DBMS you choose Below database for H2
	 * Database
	 */
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";// org.hibernate.dialect.H2Dialect
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	/*
	 * // This is for oracle database. private final static String DATABASE_URL
	 * = "jdbc:oracle:thin:@localhost:1521:xe"; private final static String
	 * DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver"; private final static
	 * String DATABASE_DIALECT = "org.hibernate.dialect.OracleDialect";//
	 * org.hibernate.dialect.H2Dialect private final static String
	 * DATABASE_USERNAME = "system"; private final static String
	 * DATABASE_PASSWORD = "root";
	 */

	// dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// Provide the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.ashish.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	// All the Hibernate properties will be returned in this method

	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
		//properties.put("hibernate.format_sql","true");
		 properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		System.out.println("This is HibernateConfig class function before getTransactionManager method!! ");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		System.out.println(
				"This is HibernateConfig class functio after getTransactionManager method!!  try" + transactionManager);
		System.out.println("This is the getTransactionManager successful");
		return transactionManager;

	}
}
