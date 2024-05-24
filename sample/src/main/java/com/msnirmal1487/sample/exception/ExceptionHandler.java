package com.msnirmal1487.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value = {NoResourceFoundException.class})
	public ApiErrorResponse noResourceFoundException(NoResourceFoundException ex) {
		return new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {NullPointerException.class})
	public ApiErrorResponse nullPointerException(NullPointerException ex) {
		return new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
	}
}
