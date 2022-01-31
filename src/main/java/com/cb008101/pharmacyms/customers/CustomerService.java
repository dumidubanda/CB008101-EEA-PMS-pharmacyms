package com.cb008101.pharmacyms.customers;

import java.util.List;
import java.util.Optional;

public interface CustomerService
{
    public void deleteCustomer(Integer id);

    public Optional<Customer> updateCustomer(Integer id, Customer cust);

    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer custom);

    public Customer getById(Integer id);

    public CustomerLogin getCustomerLogin(String email);
}
