package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.EmployeePayroll;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long>{
	
}
