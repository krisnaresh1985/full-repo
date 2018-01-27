package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/allEmployees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public Collection<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id") int id){
    	employeeService.removeEmployeeById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployeeById(@RequestBody Employee employee){
    	employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee){
    	employeeService.insertEmployee(employee);
    }
    
    
    @RequestMapping(value = "/{id}/{years}", method = RequestMethod.GET)
    public int getEmployeeYears(@PathVariable("id") int id){
        return employeeService.getEmployeeYears(id);
    }
    
    
    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public int getEmployeeAverage(){
        return employeeService.getEmployeeAverage();
    }
}
