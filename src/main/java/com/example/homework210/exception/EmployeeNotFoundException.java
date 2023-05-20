package com.example.homework210.exception;

import com.example.homework210.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Employee employee){
		super("Сотрудник " + employee.toString() +" не найден");
	}
}
