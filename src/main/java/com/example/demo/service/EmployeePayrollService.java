package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EmployeePayroll;
import com.example.demo.dto.EmployeePayrollDto;
import com.example.demo.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService {
	@Autowired
	private EmployeePayrollRepository empPayrollRepo;
	
	public EmployeePayrollDto CreateUser(EmployeePayrollDto empPayrollDto) {
		EmployeePayroll empPayroll = new EmployeePayroll(empPayrollDto.getName(), empPayrollDto.getSalary());
		return new EmployeePayrollDto(empPayrollRepo.save(empPayroll));
	}
	
	public EmployeePayrollDto UpdateUser(EmployeePayrollDto employeePayrollDto){

        return empPayrollRepo.findById(employeePayrollDto.getId()).map(employeePayroll -> {
        	employeePayroll.setName(employeePayrollDto.getName());
        	employeePayroll.setSalary(employeePayroll.getSalary());
           return new EmployeePayrollDto(empPayrollRepo.save(employeePayroll));
        }).orElse(null);
    }
	
	public EmployeePayrollDto deleteUser(Long id){
        return empPayrollRepo.findById(id).map(employeePayroll -> {
            empPayrollRepo.deleteById(employeePayroll.getId());
            return new EmployeePayrollDto(employeePayroll);
        }).orElse(null);
    }
	
	public List<EmployeePayrollDto> getAllUser(){
        return empPayrollRepo.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDto(employeePayroll))
                .collect(Collectors.toList());
    }
}
