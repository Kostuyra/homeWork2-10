package com.example.homework210;

import com.example.homework210.exception.EmployeeAlreadyAddedException;
import com.example.homework210.exception.EmployeeNameWroteWithMistake;
import com.example.homework210.exception.EmployeeNotFoundException;
import com.example.homework210.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements EmployeeServiceInterface, DepartmentsServiceInterface {
	private final List<Employee> employees;
	private static final int countEmployees = 10;

	public EmployeeService() {
		this.employees = new ArrayList<>();
	}

	@Override
	public Employee addEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		checkSizeArray();
		checkAllSymbolsIsLetter(firstName);
		checkAllSymbolsIsLetter(lastName);
		firstName = StringUtils.capitalize(firstName.toLowerCase());
		lastName = StringUtils.capitalize(lastName.toLowerCase());
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (checkExistEmployee(employee)) {
			throw new EmployeeAlreadyAddedException(employee);
		}
		employees.add(employee);
		return employee;
	}


	@Override
	public Employee removeEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		employees.remove(employee);
		return employee;
	}

	@Override
	public Employee findEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		return employee;
	}

	@Override
	public List<Employee> allEmployees() {
		return employees;
	}

	private boolean checkExistEmployee(Employee employee) {
		return employees.contains(employee);
	}

	private void checkSizeArray() {
		if (employees.size() == countEmployees) {
			throw new EmployeeStorageIsFullException();
		}
	}

	private void checkAllSymbolsIsLetter(String word) {
		if (!StringUtils.isAlpha(StringUtils.remove(word, "-"))) {
			throw new EmployeeNameWroteWithMistake(word + " содержит недопусимые символы");
		}
	}

	@Override
	public Employee getEmployeeWithMaxSalaryFromPartOffice(int departmentId) {
		return employees.stream().
				filter(e -> e.getPartOffice() == departmentId).
				max(Comparator.comparingDouble(Employee::getSalary)).get();

	}

	@Override
	public Employee getEmployeeWithMinSalaryFromPartOffice(int departmentId) {
		return employees.stream().
				filter(e -> e.getPartOffice() == departmentId).
				min(Comparator.comparingDouble(Employee::getSalary)).get();

	}

	@Override
	public List<Employee> getAllEmployeeFromPartOffice(int departmentId) {
		return employees.stream().filter(e -> e.getPartOffice() == departmentId).collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Employee>> getAllEmployeesFromAllPartOffice() {
		return employees.stream().collect(Collectors.groupingBy(Employee::getPartOffice));


	}

}

