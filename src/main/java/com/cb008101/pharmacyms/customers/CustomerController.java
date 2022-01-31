package com.cb008101.pharmacyms.customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{

	@Autowired
	private CustomerService customerService;

	//Save customer
	@RequestMapping(method = RequestMethod.POST, value = "/savecustomer")
	public  void saveCustomer(@RequestBody Customer customer)
	{
		System.out.print(customer.getName());
		customerService.saveCustomer(customer);
	}

	//Get all customers
	@RequestMapping("/getallcustomers")
	public List<Customer> getAll()
	{
		return customerService.getAllCustomers();
	}

	//Update customer
	@RequestMapping(method = RequestMethod.PUT, value="updatecustomer/{id}")
	public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer)
	{
		customerService.updateCustomer(id, customer);
	}

	//Delete Customer
	@RequestMapping(method=RequestMethod.DELETE,value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable Integer id)
	{
		customerService.deleteCustomer(id);
	}

	//Get customer by id
	@RequestMapping(method = RequestMethod.GET, value="getcustbyid/{id}")
	public Customer getCustomerById(@PathVariable Integer id)
	{
		return customerService.getById(id);
	}


	//Customer Login
	@RequestMapping(method = RequestMethod.GET, value="getcustomerlogin/{email}")
	public CustomerLogin getCustomerLogin(@PathVariable String email)
	{
		return customerService.getCustomerLogin(email);
	}




}
