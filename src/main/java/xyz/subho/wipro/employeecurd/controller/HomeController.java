package xyz.subho.wipro.employeecurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.subho.wipro.employeecurd.entity.EmployeeEntity;
import xyz.subho.wipro.employeecurd.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public boolean addEmployee(@ModelAttribute EmployeeEntity emp)	{
		
		if(employeeService.checkEmpIdExists(emp.getEmpId()))
			return false;
		
		employeeService.addEmployee(emp);
		return true;
	}
	
	@PostMapping("/delete")
	public boolean removeEmployee(@ModelAttribute EmployeeEntity emp)	{
		
		if(employeeService.checkEmpIdExists(emp.getEmpId()))	{
			employeeService.removeEmployee(emp.getEmpId());
			return true;
		}
		return false;
	}
	
	@PostMapping("/update")
	public boolean updateEmployee(@ModelAttribute EmployeeEntity emp)	{
		
		if(employeeService.checkEmpIdExists(emp.getEmpId()))	{
			employeeService.updateEmployee(emp);
			return true;
		}
		return false;
	}
	
	@PostMapping("/find")
	public EmployeeEntity findEmployee(@ModelAttribute EmployeeEntity emp)	{
		try	{
			return employeeService.findEmployee(emp.getEmpId());
		}
		catch(Exception e)	{
			return null;
		}
	}
	
	@PostMapping("/view")
	public List<EmployeeEntity> viewAllEmployee()	{
		
		return employeeService.viewEmployees();
	}
}
