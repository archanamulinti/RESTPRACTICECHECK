package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserNotExistsException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/carts")
@RestController
@Slf4j
public class CartController
{
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId) throws MenuItemNotFoundException
	{
		log.info("Inside Add to Cart");
		cartService.addCartItem(userId, menuItemId);
		log.info("Added to Cart");
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException, UserNotExistsException
	{
		log.info("Inside get all Cart items inside controller");
		List<MenuItem> list=cartService.getAllCartItems(userId);
		log.debug("Menu Items for User "+userId+" are : {} ",list);
		return list;
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId,@PathVariable long menuItemId) throws UserNotExistsException, CartEmptyException, MenuItemNotFoundException
	{
		log.info("Inside delete Cart Item inside Cart Controller");
		cartService.deleteCartItem(userId, menuItemId);
		log.debug("Cart Item deleted");
	}
}