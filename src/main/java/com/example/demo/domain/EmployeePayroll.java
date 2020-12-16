package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_payroll_data")
public class EmployeePayroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String gender;
	private String[] department;
	private Double salary;
	private String startDate;
	private String notes;
	
	public EmployeePayroll(String name, String gender, String[] department, Double salary, String startDate, String notes) {
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.startDate = startDate;
		this.notes = notes;
	}
}
