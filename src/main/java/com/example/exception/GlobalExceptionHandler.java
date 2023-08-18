package com.example.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(getErrorsInAMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

	private Map<String, List<String>> getErrorsInAMap(List<String> errors) {
		Map<String, List<String>> er = new HashMap<>();
		er.put("errors", errors);
		return er;
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(StudentNotFoundException ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());

		return new ResponseEntity<>(getErrorsInAMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(Exception ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());

		return new ResponseEntity<>(getErrorsInAMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(RuntimeException ex) {
		List<String> errors = Collections.singletonList(ex.getMessage());

		return new ResponseEntity<>(getErrorsInAMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
