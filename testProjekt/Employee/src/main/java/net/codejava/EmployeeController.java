package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	private EmployeeService  employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	/*@GetMapping("/login")
	public String login() {
		return "login";
	}*/
	@GetMapping("/employee")
	public String listEmployee(Model model) {
		model.addAttribute("employee",employeeService.getAllEmployees());
		return "employee";
		
	}
	@GetMapping("/employee/showNewEmployeeForm")
	public String createNewEmployeeForm(Model model) {
		Employee employe=new Employee();
		model.addAttribute("employee",employe);
		return "new_employee";
		
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}
	
	
	@GetMapping("/employee/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable Long id ,@ModelAttribute("employee") Employee employee, Model model ) {
		
		
		Employee exisEmploye= employeeService.getEmployeeById(id);
		exisEmploye.setId(id);
		exisEmploye.setFirstName(employee.getFirstName());
		exisEmploye.setStatus(employee.getStatus());
		exisEmploye.setTargetDate(employee.getTargetDate());
		exisEmploye.setEmail(employee.getEmail());
		exisEmploye.setDecription(employee.getDecription());
		
		employeeService.updateEmployee(exisEmploye);
		return "redirect:/employee";
		
	}
	@GetMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/employee";
		
	}
	
	
}
