package com.spring.JDBC.EmpDAO1;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import com.spring.JDBC.Entities.Student;
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


	public Boolean saveEmployeeByPreparedStatement(final Employee employee) {
		// TODO Auto-generated method stub
		String query="insert into Employee(id,name,city) values(?,?,?)";
		return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getCity());
				return ps.execute();
			}
		});
	}

	public int update1(Employee employee) {
		// TODO Auto-generated method stub
		String query="update Employee set name=?,city=? where id=?";
		int result=this.jdbctemplate.update(query,employee.getName(),employee.getCity(),employee.getId());
		return result;
	}
	
	public int delete(int id)
	{
		String query="delete from Employee where id=?";
		int result=this.jdbctemplate.update(query, id);
		return result;
		
	}


	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		String query="select * from Employee where id=?";
		RowMapper<Employee> rowMapper=new EmpRowMapperImpl();
		Employee result=this.jdbctemplate.queryForObject(query, rowMapper, id);
		return result;
	}


	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		String query="select * from employee";
		RowMapper<Employee> rowMapper=new EmpRowMapperImpl();
		List<Employee> employee=this.jdbctemplate.query(query, rowMapper);
		return employee;
	}


	
}
