package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	List<Employee> employees() {
		return employeeDao.employees();
	}
	
	Employee getEmpployee(int empId) {
		return employeeDao.getEmpployee(empId);
	}
	
	int addEmployee(Employee e) {
		return employeeDao.addEmployee(e);
	}
	
	int updateEmpployee(int empId, String name) {
		return employeeDao.updateEmpployee(empId, name);
	}
	
	int deleteEmpployee(int empId) {
		
		return employeeDao.deleteEmpployee(empId);
	}
	
}
