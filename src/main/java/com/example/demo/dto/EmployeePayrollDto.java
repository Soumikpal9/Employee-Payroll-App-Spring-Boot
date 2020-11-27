package com.example.demo.dto;

import com.example.demo.domain.EmployeePayroll;

public class EmployeePayrollDto {
	private Long id;
	private String name;
	private String salary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public EmployeePayrollDto(EmployeePayroll user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
	}
}
