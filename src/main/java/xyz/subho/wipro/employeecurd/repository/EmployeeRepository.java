package xyz.subho.wipro.employeecurd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import xyz.subho.wipro.employeecurd.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	
	public List<EmployeeEntity> findAll();

}
