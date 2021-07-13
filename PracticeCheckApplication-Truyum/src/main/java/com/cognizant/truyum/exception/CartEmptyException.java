package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart Empty")
public class CartEmptyException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartEmptyException(String msg)
	{
		super(msg);
	}

	public CartEmptyException()
	{
		super();
	}
}