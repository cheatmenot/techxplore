package com.acn.texchxplore.controller;

import com.acn.texchxplore.model.GroceryBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GroceryBillController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/grocery")
	public String getIndexPage(Model model) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<GroceryBill> groceryBill = restTemplate.exchange("http://webservice/items/bill/regular", HttpMethod.GET, entity, GroceryBill.class);
		if (groceryBill.getBody() != null){
			model.addAttribute("clerk", groceryBill.getBody().getClerk());
			model.addAttribute("regularBill", groceryBill.getBody());

			ResponseEntity<GroceryBill> groceryBillDiscounted = restTemplate.exchange("http://webservice/items/bill/discounted", HttpMethod.GET, entity, GroceryBill.class);
			model.addAttribute("discountedBill", groceryBillDiscounted.getBody());
		}
		return "grocery";
	}

}
