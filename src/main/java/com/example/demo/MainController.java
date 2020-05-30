package com.example.demo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/dashboard")
	public String dashboard(Model model) {
		
		model.addAttribute("message", "Hello from the backend!");
		
		return "dashboard/index";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/inventory")
	public String inventory(Model model) {
		
		Item item1 = new Item("1", "iPhone 6 Plus", "Get more with the iPhone 6 PLUS!", new BigDecimal(699.99));
		Item item2 = new Item("2", "FitBit", "Track steps and calories!", new BigDecimal(69.99));
		Item item3 = new Item("3", "Insignia 64\" TV", "Affordable smart TV to stream your fav shows!", new BigDecimal(799.99));
		Item item4 = new Item("4", "Kensington Wireless Mouse", "Sleek design makes this a clear winner", new BigDecimal(29.99));
		Item item5 = new Item("5", "Blue Snowball Desktop Mic", "Crisp, clear sound!", new BigDecimal(79.99));
		
		List<Item> inventoryItems = new ArrayList<Item>();
		inventoryItems.add(item1);
		inventoryItems.add(item2);
		inventoryItems.add(item3);
		inventoryItems.add(item4);
		inventoryItems.add(item5);

		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResponse = mapper.writeValueAsString(inventoryItems);
			model.addAttribute("inventoryList", jsonResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "inventory/index";
	}

}
