package com.employee;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

public class EmployeeServiceTest {
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Before
	public void beforeTest()
	{
		MockitoAnnotations.initMocks(this);

	}
	

	@Test
	public void testGetEmployeeAverage() {
		
		Employee e1 = new Employee(1,"Person-1",5);
		Employee e2 = new Employee(2,"Person-2",6);
		Employee e3 = new Employee(3,"Person-3",7);
		
		Collection<Employee> collection = new ArrayList<Employee>();
		collection.add(e1);
		collection.add(e2);
		collection.add(e3);
		
		Mockito.when(employeeDAO.getAllEmployees()).thenReturn(collection);
		
		int actualResult= employeeService.getEmployeeAverage();
		
		int expectedResult = 6;
		
		assertEquals(expectedResult,actualResult);
	}

}
