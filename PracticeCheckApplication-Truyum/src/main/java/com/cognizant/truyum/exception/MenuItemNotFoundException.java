package com.cognizant.truyum.exception;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "MenuItem Not Found")
public class MenuItemNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuItemNotFoundException(String msg)
	{
		super(msg);
	}
	public MenuItemNotFoundException()
	{
		super();
	}
}