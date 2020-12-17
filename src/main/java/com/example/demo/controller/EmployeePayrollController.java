package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeePayrollDto;
import com.example.demo.service.EmployeePayrollService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EmployeePayrollController {
	@Autowired
	EmployeePayrollService employeePayrollService;
	
	@PostMapping("/post")
    public ResponseEntity<EmployeePayrollDto> createUser(@Valid @RequestBody EmployeePayrollDto user){
		log.debug("Employee DTO : " + user.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(employeePayrollService.CreateUser(user));
    }
	
	@GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDto>> getAllUser(){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUser());
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeePayrollDto> getUserById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getUserById(id));
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeePayrollDto>> getUserByDepartment(@PathVariable("department") String department){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getEmployeesByDepartment(department));
	}
	
	@PutMapping("/update")
    public ResponseEntity<EmployeePayrollDto> updateUser(@Valid @RequestBody EmployeePayrollDto user){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.UpdateUser(user));
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeePayrollDto> deleteUser(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeePayrollService.deleteUser(id));
    }
	
}
