package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	// create table emp(emp_id int ,name varchar(30),dept varchar(30), sal int);
	int empId;
	String name;
	String dept;
	int sal;
	
	public String printMyData() {
		System.out.println("Printing my data . . . ");
		return "Done";
	}
	
	
	public Employee() {
		super();
	
	}


	public Employee(int empId, String name, String dept, int sal) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.sal = sal;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", sal=" + sal + "]";
	}

}
