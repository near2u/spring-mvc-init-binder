package com.project.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
	
	@ExceptionHandler(value=RuntimeException.class)
	public String exceptionHandler() {
		return "error";
	}
}
