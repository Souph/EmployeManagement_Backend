package xyz.subho.wipro.employeecurd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.subho.wipro.employeecurd.entity.EmployeeEntity;
import xyz.subho.wipro.employeecurd.repository.EmployeeRepository;
import xyz.subho.wipro.employeecurd.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean checkEmpIdExists(Long empId)	{
		
		return employeeRepository.existsById(empId);
	}
	
	public boolean addEmployee(EmployeeEntity emp)	{
		try {
			employeeRepository.save(emp);
			return true;
		}
		catch(Exception e)	{
			return false;
		}
	}
	
	public void removeEmployee(Long empId)	{
		
		employeeRepository.deleteById(empId);
	}
	
	public void updateEmployee(EmployeeEntity emp)	{
		
		employeeRepository.save(emp);
	}
	
	public EmployeeEntity findEmployee(Long empId)	{
		
		return employeeRepository.findById(empId).get();
	}

	public List<EmployeeEntity> viewEmployees() {
		
		return employeeRepository.findAll();
	}
}
