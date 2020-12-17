package com.example.demo.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	
	private static final String message = "Exception while processing REST Request";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(
											HttpMessageNotReadableException exception){
		log.error("Invaid Date Format", exception);
		ResponseDto responseDto = new ResponseDto(message, "Should have date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(
											MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream()
											 .map(objErr -> objErr.getDefaultMessage())
											 .collect(Collectors.toList());
		ResponseDto responseDto = new ResponseDto(message, errorMessage);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDto responseDto = new ResponseDto(message, exception.getMessage());
		return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
	}
	
}
