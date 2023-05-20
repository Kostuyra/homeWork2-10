package com.example.homework210;

public class Employee {
	private final String firstName;
	private final String lastName;
	private  Integer partOffice;
	private  Double salary;

	public Employee(String firstName, String lastName, Integer partOffice, Double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.partOffice = partOffice;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "ФИО: " + firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getPartOffice() {
		return partOffice;
	}

	public Double getSalary() {
		return salary;
	}

	public void setPartOffice(Integer partOffice) {
		this.partOffice = partOffice;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String fullName(){
		return firstName + " " + lastName;
	}
	@Override
	public int hashCode() {
		return java.util.Objects.hash(firstName, lastName) + partOffice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Employee employee2 = (Employee) obj;
		return firstName.equals(employee2.getFirstName()) && lastName.equals(employee2.getLastName());

	}
}
