package xyz.subho.wipro.employeecurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.subho.wipro.employeecurd.entity.EmployeeEntity;
import xyz.subho.wipro.employeecurd.service.EmployeeService;

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
	
	@PostMapping("/delete/{empId}")
	public boolean removeEmployee(@PathVariable Long empId)	{
		
		if(employeeService.checkEmpIdExists(empId))	{
			employeeService.removeEmployee(empId);
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
	
	@PostMapping("/find/{empId}")
	public EmployeeEntity findEmployee(@PathVariable Long empId)	{
		try	{
			return employeeService.findEmployee(empId);
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
