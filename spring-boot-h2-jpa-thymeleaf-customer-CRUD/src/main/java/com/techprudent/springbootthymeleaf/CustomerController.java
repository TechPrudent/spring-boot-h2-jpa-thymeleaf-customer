package com.techprudent.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

	@GetMapping(path = "/customers/add")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "edit";
    }

    @PostMapping(path = "/customers/save")
    public String saveCustomer(Customer customer) {
    	customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping(path = "/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

    @GetMapping(path = "/customers/edit/{id}")
    public String editCustomer(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("customer", customerRepository.findById(id));
        return "edit";
    }

    @GetMapping(path = "/customers/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") long id) {
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }
}