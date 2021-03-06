package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found")
public class UserNotExistsException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotExistsException(String msg)
	{
		super(msg);
	}
	public UserNotExistsException()
	{
		super();
	}
}