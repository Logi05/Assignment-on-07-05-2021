package com.spring.JDBC.EmpDAO1;

import java.util.List;

import com.spring.JDBC.Entities.Student;
import com.spring.JDBC1.Employee;

public interface EmployeeDAO {
	public int insert(Employee employee);
	public Boolean saveEmployeeByPreparedStatement(final Employee employee);
	public int update1(Employee employee);
	public int delete(int id);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
}
