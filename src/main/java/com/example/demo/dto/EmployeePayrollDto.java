package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.domain.EmployeePayroll;

import lombok.Data;

@Data
public class EmployeePayrollDto {
	private Long id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	private String name;
	
	@NotEmpty(message = "Gender can't be empty")
	private String gender;
	
	@NotEmpty(message = "Department can't be empty")
	private String[] department;
	
	@NotEmpty(message = "Salary can't be empty")
	@Min(value = 500, message = "Min Wage should be more than 500")
	private Double salary;
	
	@NotEmpty(message = "Start Date can't be empty")
	private String startDate;
	
	private String notes;

	public EmployeePayrollDto(EmployeePayroll employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.gender = employee.getGender();
		this.department = employee.getDepartment();
		this.salary = employee.getSalary();
		this.startDate = employee.getStartDate();
		this.notes = employee.getNotes();
	}
}
