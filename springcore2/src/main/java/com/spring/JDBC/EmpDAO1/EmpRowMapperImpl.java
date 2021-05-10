package com.spring.JDBC.EmpDAO1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.JDBC1.Employee;

public class EmpRowMapperImpl implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee em=new Employee();
		em.setId(rs.getInt(1));
		em.setName(rs.getNString(2));
		em.setCity(rs.getNString(3));
		return em;
	}

}
