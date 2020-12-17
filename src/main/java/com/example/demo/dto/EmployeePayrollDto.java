package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.example.demo.domain.EmployeePayroll;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDto {
	private Long id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	private String name;
	
	@Pattern(regexp = "M|F", message = "Gender needs to be male or female")
	private String gender;
	
	@NotNull(message="Departments should not be empty")
	private List<String> department;
	
	@Min(value = 500, message = "Min Wage should be more than 500")
	private Double salary;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message="Start Date should not be empty")
	@PastOrPresent(message="Start Date should be past or todays date")
	private LocalDate start_date;
	
	@NotBlank(message="Profile Picture cannot be empty")
	private String profile_pic;
	
	private String notes;
	
	public EmployeePayrollDto() { 
		
	}

	public EmployeePayrollDto(EmployeePayroll employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.gender = employee.getGender();
		this.department = employee.getDepartment();
		this.salary = employee.getSalary();
		this.start_date = employee.getStart_date();
		this.profile_pic = employee.getProfile_pic();
		this.notes = employee.getNotes();
	}
}
