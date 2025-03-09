package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopApp {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("BeansAOP123.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AopAppConfig.class);

		Employee employee = context.getBean(Employee.class);
		System.out.println(employee.getName());
		System.out.println(employee.getDept());
	}
}
