package com.jay.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jay.springdemo.dao.EmployeeDAO;
import com.jay.springdemo.entity.Employee;
import com.jay.springdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		
			List<Employee> theEmployee=employeeService.getEmployees();
			
			model.addAttribute("employees",theEmployee);
		
		return "list-employee";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee=new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveCustomer(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		Employee theEmployee=employeeService.getEmployee(theId);
		
		theModel.addAttribute("employee",theEmployee);
			
		return "employee-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteEmployee(theId);
		
		
		return "redirect:/employee/list";
	}

}
