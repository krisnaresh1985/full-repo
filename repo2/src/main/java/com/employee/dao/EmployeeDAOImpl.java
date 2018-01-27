package com.employee.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Qualifier("localData")
public class EmployeeDAOImpl implements EmployeeDAO {

    private static Map<Integer, Employee> employees;

    static {

        employees = new HashMap<Integer, Employee>(){

            {
                put(1, new Employee(1, "Vicki", 5));
                put(2, new Employee(2, "Alex U",6));
                put(3, new Employee(3, "Anna",7));
            }
        };
    }

    @Override
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    @Override
    public Employee getEmployeeById(int id){
        return employees.get(id);
    }

    @Override
    public void removeEmployeeById(int id) {
        employees.remove(id);
    }

    @Override
    public void updateEmployee(Employee employee){
        Employee e = employees.get(employee.getId());
        e.setYears(employee.getYears());
        e.setName(employee.getName());
        employees.put(employee.getId(), employee);
    }

    @Override
    public void insertEmployeeToDb(Employee employee) {
        employees.put(employee.getId(), employee);
    }

	@Override
	public int getEmployeeYears(int id) {
		// TODO Auto-generated method stub
		return employees.get(id).getYears();
	}
}
