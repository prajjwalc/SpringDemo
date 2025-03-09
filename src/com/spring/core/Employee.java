package com.spring.core;

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
	
	@Autowired
	@Qualifier("myDept")
	Dept dept2;
	
	public Dept getDept2() {
		return dept2;
	}

	public void setDept2(Dept dept2) {
		this.dept2 = dept2;
	}

	public String printMyData() {
		System.out.println("Printing my data . . . ");
		return "Done";
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

	//@Override
	public String toString1() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", sal=" + sal + "]";
	}

}
