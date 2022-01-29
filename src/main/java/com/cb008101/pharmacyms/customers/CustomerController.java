package com.cb008101.pharmacyms.customers;


import com.cb008101.pharmacyms.security.customerlogin.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST, value = "/savecustomer")
	public  void saveCustomer(@RequestBody Customer customer) {
		System.out.print(customer.getName());
		customerService.saveCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.GET, value="getcustbyid/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return customerService.getById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value="updatecustomer/{id}")
	public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customerService.updateCustomer(id, customer);
	}

	@RequestMapping("/getallcustomers")
	public List<Customer> getAll(){
		return customerService.getAllCustomers();
	}

	@RequestMapping(method = RequestMethod.GET, value="getcustomerlogin/{email}")
	public CustomerLogin getCustomerLogin(@PathVariable String email) {
		return customerService.getCustomerLogin(email);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
	}


}
