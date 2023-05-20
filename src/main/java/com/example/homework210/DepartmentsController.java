package com.example.homework210;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
	private final DepartmentsServiceInterface departmentsServiceInterface;

	public DepartmentsController(DepartmentsServiceInterface departmentServiceInterface) {
		this.departmentsServiceInterface = departmentServiceInterface;
	}

	@GetMapping("/max-salary")
	Employee getEmployeeWithMaxSalaryFromPartOffice(@RequestParam int departmentId) {
		return departmentsServiceInterface.getEmployeeWithMaxSalaryFromPartOffice(departmentId);
	}

	@GetMapping("/min-salary")
	Employee getEmployeeWithMinSalaryFromPartOffice(@RequestParam int departmentId) {
		return departmentsServiceInterface.getEmployeeWithMinSalaryFromPartOffice(departmentId);
	}

	@GetMapping("/all/")
	List<Employee> getAllEmployeeFromPartOffice(@RequestParam int departmentId) {
		return departmentsServiceInterface.getAllEmployeeFromPartOffice(departmentId);
	}

	@GetMapping("/all")
	Map<Integer, List<Employee>> getAllEmployeesFromAllPartOffice() {
		return departmentsServiceInterface.getAllEmployeesFromAllPartOffice();
	}


}
