package com.techprudent.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

	@Autowired
	CustomerRepo cr;
	
	@Override
	public void run(String... args) throws Exception {

		this.cr.save(new Customer( "customer1", "25", "Male"));
		this.cr.save(new Customer( "customer2", "25", "Male"));
		this.cr.save(new Customer( "customer3", "65", "Female"));
		
	}

}
