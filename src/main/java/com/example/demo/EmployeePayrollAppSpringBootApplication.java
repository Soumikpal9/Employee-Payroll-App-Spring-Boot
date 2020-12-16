package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppSpringBootApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppSpringBootApplication.class, args);
		
		log.info("Employee Payroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));
		
		log.info("Employee Payroll DB USer is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
 