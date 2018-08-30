package com.techprudent.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private CustomerRepository customerRepository;

    @Autowired
    public DataLoader(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
    
    @Override
    public void run(String... strings) throws Exception {

        Customer c1 = new Customer();
        c1.setName("c1");
        c1.setAge("22");
        c1.setGender("m");

        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setName("c2");
        c2.setAge("32");
        c2.setGender("f");

        customerRepository.save(c2);    }

	
}