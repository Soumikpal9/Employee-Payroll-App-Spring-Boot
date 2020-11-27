package com.example.demo.controller;

import java.util.List;

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

@RestController
public class EmployeePayrollController {
	@Autowired
	EmployeePayrollService employeePayrollService;
	
	@PostMapping("/post")
    public ResponseEntity<EmployeePayrollDto> createUser(@RequestBody EmployeePayrollDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeePayrollService.CreateUser(user));
    }
	
	@GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDto>> getAllUser(){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUser());
    }
	
	@PutMapping("/update")
    public ResponseEntity<EmployeePayrollDto> updateUser(@RequestBody EmployeePayrollDto user){
		return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.UpdateUser(user));
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeePayrollDto> deleteUser(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeePayrollService.deleteUser(id));
    }
}
