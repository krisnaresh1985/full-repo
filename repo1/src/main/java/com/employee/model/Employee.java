package com.employee.model;

public class Employee {

    private int id;
    private String name;
    private int years;

    public Employee(int id, String name, int years) {
        this.id = id;
        this.name = name;
        this.years = years;
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
