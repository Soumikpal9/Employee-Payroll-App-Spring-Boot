package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.EmployeePayroll;
import com.example.demo.dto.EmployeePayrollDto;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long>{
	@Query(value="select * from employee_payroll_data, employee_department where id = id and department = :department", nativeQuery=true)
	List<EmployeePayrollDto> findEmployeesByDepartment(String department);
}
