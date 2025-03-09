package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDaoApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		List<Employee> employees = employeeService.employees();		
		System.out.println(employees);
		
		Employee employee = employees.get(0);
		employeeService.addEmployee(new Employee(10, "Emp 10", "HR", 1000));
		//employeeService.updateEmpployee(employee.getEmpId(), "Updated "+ employee.getName());
		
		System.out.println(employeeService.getEmpployee(employee.getEmpId()));
		
		//employeeService.deleteEmpployee(employee.getEmpId());
		
		
		
	}
}
