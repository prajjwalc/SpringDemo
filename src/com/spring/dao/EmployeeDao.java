package com.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate parameterJdbcTemplate;

	@Autowired
	PlatformTransactionManager transactionManager;

	List<Employee> employees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT emp_id, name,dept, sal FROM Emp";
		employees = jdbcTemplate.query(sql, new EmployeeMapper());

		return employees;
	}

	Employee getEmpployee(int empId) {
		System.out.println("Get Employee with Empid:" + empId);
		String sql = "select emp_id, name,dept, sal from Emp where emp_id=" + empId;
		Employee result = jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee employee = new Employee();
				while (rs.next()) {

					employee.setEmpId(rs.getInt("emp_id"));
					employee.setName(rs.getString("name"));
					employee.setDept(rs.getString("dept"));
					employee.setSal(rs.getInt("sal"));
				}
				return employee;

			}

		});

		return result;
	}

	int addEmployee(Employee e) {
		System.out.println("Adding employee : " + e);
		String query = "insert into emp values (:id,:name,:dept,:sal)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getEmpId());
		map.put("name", e.getName());
		map.put("dept", e.getDept());
		map.put("sal", e.getSal());

		parameterJdbcTemplate.execute(query, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement arg0) throws SQLException, DataAccessException {

				return arg0.executeUpdate();
			}
		});

		return 1;
	}

	int updateEmpployee(int empId, String name) {
		TransactionStatus transactionStatus = 
				transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			System.out.println("Delete Empid:" + 10);
			String sql1 = "Delete from Emp where emp_id=" + 10;
			jdbcTemplate.update(sql1);
			
			System.out.println("Empid:" + empId + " | Name:" + name);
			String sql = "Update Emp set name='" + name+ "' where emp_id=" + empId;
			int result = jdbcTemplate.update(sql);
			
			transactionManager.commit(transactionStatus);
			
			return result;
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			
			System.out.println("Exception e:" + e);
		}
		return 1;
	}

	int deleteEmpployee(int empId) {
		System.out.println("Delete Empid:" + empId);
		String sql = "Delete from Emp where emp_id=" + empId;
		int result = jdbcTemplate.update(sql);

		return result;
	}
}
