package com.cognizant.truyum.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/menu-items")
@Slf4j
public class MenuItemController
{
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping
	public ArrayList<MenuItem> getAllMenuItems()
	{
		log.info("Inside All Menu Items");
		ArrayList<MenuItem> itemList = menuItemService.getMenuItemListCustomer();
		log.debug("Menu Item List :: {}", itemList);
		return itemList;
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) throws MenuItemNotFoundException
	{
		log.info("Inside Menu Item by id");
		MenuItem menuItem = menuItemService.getMenuItem(id);
		log.debug("Menu item :: {}", menuItem);
		return menuItem;
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) throws MenuItemNotFoundException
	{
		log.info("Inside ModifyMenuItem");
		menuItemService.save(menuItem);
		log.debug("Modified item :: {}", menuItem);
		log.info("Modified");
	}
}