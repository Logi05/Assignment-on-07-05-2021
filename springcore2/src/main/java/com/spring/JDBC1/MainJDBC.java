package com.spring.JDBC1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.JDBC.DAO.StudentDAO;
import com.spring.JDBC.EmpDAO1.EmployeeDAO;
import com.spring.JDBC.Entities.Student;

public class MainJDBC {
	public static void main(String[] args) {
		System.out.println("Main Method");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/JDBC1/ConfigJDBC.xml");
		/*JdbcTemplate jdbc=(JdbcTemplate)context.getBean("jdbctemplate");
		String query="insert into Employee(id,name,city) values(?,?,?)";
		int result = jdbc.update(query,102,"Sankari","Trichy");
		System.out.println("Records inserted: "+result);*/
		
		EmployeeDAO emp=(EmployeeDAO) context.getBean("empDAO");
		//emp.saveEmployeeByPreparedStatement(new Employee (104,"Rahul","Erode"));
    	//emp.saveEmployeeByPreparedStatement(new Employee (103,"Yogi","Chennai"));
		
		
    	/*Employee employee=new Employee();
    	employee.setId(105);
    	employee.setName("Preethi");
    	employee.setCity("Namakal");
    	int result=emp.insert(employee);
    	System.out.println(result);*/
    	
    	Employee employee=new Employee();
    	employee.setId(105);
    	employee.setName("Anupama");
    	employee.setCity("Mettur");
    	int result=emp.update1(employee);
    	System.out.println(result);
    	
    	//int result1=emp.delete(103);
    	//System.out.println(result1+" rows affected");
    	
    	Employee employee1=emp.getEmployee(105);
    	System.out.println(employee1);
    	
    	List<Employee> EmpList=emp.getAllEmployee();
    	for(Employee e:EmpList)
    	{
    		System.out.println(e);
    	}
	}
}
