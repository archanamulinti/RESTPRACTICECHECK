package com.cognizant.truyum.exception;

import java.util.Map;
import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
//@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(MenuItemNotFoundException.class)
	public Map <String,String> handleMenuItemNotFoundExcetion()
	{
		Map <String,String> map = new HashMap<>();
		map.put("error","menu item not found");
		return map;
	}
	
//	@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
//	{
//        log.info("Start");
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        // Get all validation errors
//        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
//
//        // Add errors to the response map        
//        body.put("errors", errors);
//
//        log.info("End");
//        return new ResponseEntity<>(body, headers, status);
//    }
//	
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status,WebRequest request)
//	{
//		Map<String, Object> body = new LinkedHashMap<>();
//	    body.put("timestamp", new Date());
//	    body.put("status", status.value());
//	    body.put("error", "Bad Request");
//	    @SuppressWarnings("unused")
//		List<String> errors = new ArrayList<String>();
//	    if (ex.getCause() instanceof InvalidFormatException)
//	    {
//	    	final Throwable cause = ex.getCause() == null ? ex : ex.getCause();
//	        for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath())
//	        {
//	        	body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
//	        }
//	    }
//        return new ResponseEntity<>(body, headers, status);
//	}
}