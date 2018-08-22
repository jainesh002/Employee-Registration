package com.jay.springdemo.dao;

import java.util.List;

import com.jay.springdemo.entity.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getEmloyees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmloyee(int theId);

	public void deleteEmployee(int theId);
	

}
