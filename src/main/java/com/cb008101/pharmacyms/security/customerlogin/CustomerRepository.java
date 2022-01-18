package com.cb008101.pharmacyms.security.customerlogin;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


//Employee = Entity Class
//Integer = Primary Key type in entity class

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Optional<Customer> findCustomerByEmail(String email);
}
