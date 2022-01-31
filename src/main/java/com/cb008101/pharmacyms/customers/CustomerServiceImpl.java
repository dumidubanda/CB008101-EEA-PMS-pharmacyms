package com.cb008101.pharmacyms.customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer custom)
    {
        customerRepository.save(custom);
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    @Override
    public Customer getById(Integer id)
    {
        Optional<Customer> cust = Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer id")));
        Customer customer = cust.get();
        return customer;
    }

    @Override
    public Optional<Customer> updateCustomer(Integer id, Customer cust)
    {
        return customerRepository.findById(id).map(c ->
        {
            c.setName(cust.getName());
            c.setEmail(cust.getEmail());
            c.setMobile(cust.getMobile());
            return c;
        });
    }

    @Override
    public void deleteCustomer(Integer id)
    {
        customerRepository.deleteById(id);

    }

    @Override
    public CustomerLogin getCustomerLogin(String email)
    {
        Optional<Customer> cust = Optional.ofNullable(customerRepository.findCustomerByEmail(email).orElseThrow(() -> new IllegalArgumentException("Invalid customer email")));
        CustomerLogin customerLogin = cust.get().getCustomerLogin();
        return customerLogin;
    }

}
