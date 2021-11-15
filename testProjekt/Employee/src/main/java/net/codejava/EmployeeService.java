package net.codejava;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService {
List<Employee> getAllEmployees();

   Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	

	void deleteEmployeeById(Long id);
}
