package com.example.homework210;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeServiceInterface employeeServiceInterface;

	public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
		this.employeeServiceInterface = employeeServiceInterface;
	}

	@GetMapping("/add")
	Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName, @RequestParam Integer departmentId, Double salary ) {
		return employeeServiceInterface.addEmployee(firstName, lastName, departmentId, salary);
	}


	@GetMapping("/delete")
	Employee removeEmployee(@RequestParam() String firstName, @RequestParam() String lastName, @RequestParam Integer departmentId, Double salary) {
		return employeeServiceInterface.removeEmployee(firstName, lastName, departmentId, salary);
	}

	@GetMapping("/find")
	Employee findEmployee(@RequestParam() String firstName, @RequestParam() String lastName, @RequestParam Integer departmentId, Double salary) {
	return employeeServiceInterface.findEmployee(firstName, lastName, departmentId, salary);
	}

	@GetMapping()
	List<Employee> allEmployees() {
		return employeeServiceInterface.allEmployees();
	}


}
