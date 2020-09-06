package xyz.subho.wipro.employeecurd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {

	@Id
	public Long empId;
	public String name;
	public Long salary;
	
	public EmployeeEntity() {
		this.empId = 0L;
		this.name = null;
		this.salary = 0L;
	}
	
	/**
	 * @param empId
	 * @param name
	 * @param salary
	 */
	public EmployeeEntity(Long empId, String name, Long salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}
	
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}
	
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
