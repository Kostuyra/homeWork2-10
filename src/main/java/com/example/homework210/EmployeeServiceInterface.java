package com.example.homework210;
import java.util.List;



public interface EmployeeServiceInterface {

	Employee addEmployee(String firstName, String lastName, Integer partOffice, Double salary);

	Employee removeEmployee(String firstName, String lastName, Integer partOffice, Double salary);

	Employee findEmployee(String firstName, String lastName, Integer partOffice, Double salary);

	List<Employee> allEmployees();

}
