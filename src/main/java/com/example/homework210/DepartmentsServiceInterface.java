package com.example.homework210;

import java.util.List;
import java.util.Map;

public interface DepartmentsServiceInterface {
	Employee getEmployeeWithMaxSalaryFromPartOffice(int departmentId);
	Employee getEmployeeWithMinSalaryFromPartOffice(int departmentId);
	List<Employee> getAllEmployeeFromPartOffice(int departmentId);
	Map<Integer,List<Employee>> getAllEmployeesFromAllPartOffice();
}
