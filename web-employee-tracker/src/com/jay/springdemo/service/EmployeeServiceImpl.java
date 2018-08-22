package com.jay.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.springdemo.dao.EmployeeDAO;
import com.jay.springdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmloyees();
		
		
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmloyee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(theId);
		
	}

}
