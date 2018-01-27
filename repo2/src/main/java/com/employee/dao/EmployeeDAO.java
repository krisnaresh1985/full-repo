package com.employee.dao;

import java.util.Collection;

import com.employee.model.Employee;


public interface EmployeeDAO {
	
    Collection<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void removeEmployeeById(int id);

    void updateEmployee(Employee employee);

    void insertEmployeeToDb(Employee employee);

	int getEmployeeYears(int id);
}
