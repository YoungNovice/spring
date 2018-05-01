package com.ssm.chapter10.main;

import com.ssm.chapter10.annotation.config.ApplicationConfig;
import com.ssm.chapter10.annotation.config.AutowiredConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationMain {

	public static void main(String[] args) {
		// test4();
	}

	private static void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
	}

	private static void test2() {
		ApplicationContext context = 
			     new AnnotationConfigApplicationContext(ApplicationConfig.class);
			String url = context.getEnvironment().getProperty("jdbc.database.url");
			System.out.println(url);
	}
}
