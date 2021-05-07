package com.spring.JDBC.EmpDAO1;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.JDBC1.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	

	public EmployeeDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "EmployeeDAOImpl [jdbctemplate=" + jdbctemplate + "]";
	}


	public int insert(Employee employee) {
		String query="insert into Employee(id,name,city) values(?,?,?)";
		int result = this.jdbctemplate.update(query,employee.getId(),employee.getName(),employee.getCity());
		return result;
	}
	

}
