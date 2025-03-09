package com.spring.core;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApplication {

	public static void main(String[] args) throws SQLException {
		
		Employee employee1 = new Employee();
		System.out.println(employee1.printMyData());
		employee1.setDept2(new Dept());
		System.out.println(employee1.getDept2().printMyData());
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ApplicationContext contextXml = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld helloWorld = contextXml.getBean(HelloWorld.class);
		System.out.println("helloWorld:"+helloWorld.getMessage());
		
		System.out.println("Started . . ." + context.getBeanDefinitionCount());
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println("beanName . . ." + beanName);
		}

		DataSource dataSource = (DataSource)context.getBean("mySqlDataSource");
		System.out.println(dataSource.getLoginTimeout());
		Employee employee = (Employee) context.getBean("employee");

		Employee employee2 = (Employee) context.getBean("employee");
		Employee employee3 = (Employee) context.getBean("employee");
		System.out.println(employee.printMyData());
		
		System.out.println("employee"+employee);
		System.out.println("employee2"+employee2);
		System.out.println("employee3"+employee3);
		
		System.out.println("employee ->"+new Employee());
		System.out.println("employee2 ->"+new Employee());
		System.out.println("employee3 ->"+new Employee());
		
		Dept dept = (Dept)context.getBean("dept");
		dept.printMyData();
		
		
	}
}
