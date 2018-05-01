package com.ssm.chapter10.annotation.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

//@ComponentScan(basePackageClasses = { Role.class})
//@ComponentScan(basePackageClasses = {}, basePackages = {"com.ssm.chapter10.annotation.pojo",
//"com.ssm.chapter10.annotation.service"})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"},
// basePackageClasses = {Role.class, RoleServiceImpl.class})

//测试test8的时候引入下面的XML，同时注释现有数据库连接池的方法
//@ImportResource({"classpath:spring-dataSource.xml"})
@PropertySource(value={"classpath:database-config.properties"}, ignoreResourceNotFound=true)
public class ApplicationConfig {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/***
	 * 测试test8的时候需要注释掉整个datasource，否则会抛异常
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		Properties props = new Properties();
		props.setProperty("driver", "com.mysql.jdbc.Driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/chapter10");
		props.setProperty("username", "root");
		props.setProperty("password", "123456");
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	
//	@Bean(name = "dataSource")
//	@Conditional({DataSourceCondition.class})
//	public DataSource getDataSource(
//			@Value("${jdbc.database.driver}") String driver,
//			@Value("${jdbc.database.url}") String url,
//			@Value("${jdbc.database.username}") String username, 
//			@Value("${jdbc.database.password}") String password) {
//		Properties props = new Properties();
//		props.setProperty("driver", driver);
//		props.setProperty("url", url);
//		props.setProperty("username", username);
//		props.setProperty("password", password);
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
	
}