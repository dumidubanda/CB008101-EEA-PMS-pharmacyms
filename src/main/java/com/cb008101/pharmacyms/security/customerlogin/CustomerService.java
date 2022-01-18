package com.cb008101.pharmacyms.security.customerlogin;

import java.util.List;
import java.util.Optional;

public interface CustomerService
{
    public void saveCustomer(Customer cust);

    public List<Customer> getAllCustomers();

    public Customer getById(Integer id);

    public Optional<Customer> updateCustomer(Integer id, Customer cust);

    public void deleteCustomer(Integer id);

    public CustomerLogin getCustomerLogin(String email);
}
