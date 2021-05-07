package com.spring.JDBC1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.JDBC.DAO.StudentDAO;
import com.spring.JDBC.EmpDAO1.EmployeeDAO;
import com.spring.JDBC.Entities.Student;

public class MainJDBC {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/JDBC1/ConfigJDBC.xml");
		/*JdbcTemplate jdbc=(JdbcTemplate)context.getBean("jdbctemplate");
		String query="insert into Employee(id,name,city) values(?,?,?)";
		int result = jdbc.update(query,102,"Sankari","Trichy");
		System.out.println("Records inserted: "+result);*/
		
		EmployeeDAO stud1=(EmployeeDAO) context.getBean("empDAO");
    	Employee employee=new Employee();
    	employee.setId(105);
    	employee.setName("Preethi");
    	employee.setCity("Namakal");
    	int result=stud1.insert(employee);
    	System.out.println(result);
	}
}
