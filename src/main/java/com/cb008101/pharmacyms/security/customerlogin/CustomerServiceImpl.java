package com.cb008101.pharmacyms.security.customerlogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerRepository.save(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer id")));
		Customer customer = cust.get();
		return customer;
	}

	@Override
	public Optional<Customer> updateCustomer(Integer id, Customer cust) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).map(c -> {
			c.setName(cust.getName());
			c.setEmail(cust.getEmail());
			c.setMobile(cust.getMobile());
			return c;
		});
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);

	}

	@Override
	public CustomerLogin getCustomerLogin(String email) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = Optional.ofNullable(customerRepository.findCustomerByEmail(email).orElseThrow(() -> new IllegalArgumentException("Invalid customer email")));
		CustomerLogin customerLogin = cust.get().getCustomerLogin();
		return customerLogin;
	}

}
