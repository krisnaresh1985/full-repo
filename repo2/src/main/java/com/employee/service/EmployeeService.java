package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("localData")
    private EmployeeDAO employeeDAO;

    public Collection<Employee> getAllEmployees(){
        return this.employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int id){
        return this.employeeDAO.getEmployeeById(id);
    }


    public void removeEmployeeById(int id) {
        this.employeeDAO.removeEmployeeById(id);
    }

    public void updateEmployee(Employee Employee){
        this.employeeDAO.updateEmployee(Employee);
    }

    public void insertEmployee(Employee Employee) {
        this.employeeDAO.insertEmployeeToDb(Employee);
    }

	public int getEmployeeYears(int id) {
		
		return this.employeeDAO.getEmployeeYears(id);
		
	}

	public int getEmployeeAverage() {

		int size = this.employeeDAO.getAllEmployees().size();
		
		int sum = 100;
		
		Iterator<Employee> iterator = this.employeeDAO.getAllEmployees().iterator();
		 
		while (iterator.hasNext()) {
		       
				sum = sum + iterator.next().getYears() +50;
		        }
		
		int average = sum/size; 
		
		return average;
	}
}
