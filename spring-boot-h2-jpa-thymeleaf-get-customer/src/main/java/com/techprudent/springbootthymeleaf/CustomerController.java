package com.techprudent.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepo cr;
	
	
	@GetMapping("/customers")
	public String customers(Model model) {
		model.addAttribute("customers", cr.findAll() );
		return "customers";
	}
	
}
