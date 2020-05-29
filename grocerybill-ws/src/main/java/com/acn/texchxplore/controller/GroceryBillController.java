package com.acn.texchxplore.controller;

import com.acn.texchxplore.impl.RegularBill;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.ShoppingClerk;
import com.acn.texchxplore.impl.DiscountedBill;
import com.acn.texchxplore.repository.ItemRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items/bill")
public class GroceryBillController {

	public GroceryBillController() {
		shoppingClerk = new ShoppingClerk("TechXplore");
	}

	@Autowired
	private ItemRepository itemRepo;

	private ShoppingClerk shoppingClerk;

	@GetMapping(value = "/discounted", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroceryBill getTotalDiscountedBill() {

		GroceryBill grocery = new DiscountedBill(shoppingClerk);
		grocery.setItemList(itemRepo.findAll());

		return grocery;

	}

	@GetMapping(value = "/regular", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroceryBill getRegularBill(){

		GroceryBill grocery = new RegularBill(shoppingClerk);
		grocery.setItemList(itemRepo.findAll());

		return grocery;
	}
}
