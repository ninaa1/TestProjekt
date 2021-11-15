package net.codejava;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get(); 
		
		
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
		
	}
	
	


}
