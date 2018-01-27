package com.employee;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.employee.controller.EmployeeController;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeControllerTest {
	
	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
		 mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


	}
	
	@Test
	public void test() throws Exception {
		
		Employee e1 = new Employee(1, "Vicki",5);
		Employee e2 = new Employee(2, "Alex U",6);
		Employee e3 =  new Employee(3, "Anna",8);
		
		Collection<Employee> collection = new ArrayList<Employee>();
		collection.add(e1);
		collection.add(e2);
		collection.add(e3);
		
		Mockito.when(employeeService.getAllEmployees()).thenReturn(collection);		
		
		 mockMvc.perform(get("/employees/all"))
		 								.andExpect(status().isOk())
		 								.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		 								.andExpect(jsonPath("$[0].name").value("Vicki"));
	}

}
