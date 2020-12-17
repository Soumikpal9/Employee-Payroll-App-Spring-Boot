package com.example.demo.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_payroll_data")
public class EmployeePayroll implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@ElementCollection
	@CollectionTable(name="employee_department", joinColumns=@JoinColumn(name="id"))
	@Column(name="department")
	private List<String> department;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="start_date")
	private LocalDate start_date;
	
	@Column(name="profile_pic")
	private String profile_pic;
	
	@Column(name="notes")
	private String notes;
	
	public EmployeePayroll() {
		
	}
	
	public EmployeePayroll(String name, String gender, List<String> department, Double salary, LocalDate start_date, String profile_pic, String notes) {
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.start_date = start_date;
		this.profile_pic = profile_pic;
		this.notes = notes;
	}
}
