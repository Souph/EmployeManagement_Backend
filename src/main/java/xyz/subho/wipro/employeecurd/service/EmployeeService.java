package xyz.subho.wipro.employeecurd.service;

import java.util.List;

import xyz.subho.wipro.employeecurd.entity.EmployeeEntity;

public interface EmployeeService {
	
	public boolean checkEmpIdExists(Long empId);
	
	public boolean addEmployee(EmployeeEntity emp);
	
	public void removeEmployee(Long empId);
	
	public void updateEmployee(EmployeeEntity emp);
	
	public EmployeeEntity findEmployee(Long empId);
	
	public List<EmployeeEntity> viewEmployees();

}
