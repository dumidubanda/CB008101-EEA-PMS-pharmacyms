package com.cb008101.pharmacyms.web;


import com.cb008101.pharmacyms.brand.BrandService;
import com.cb008101.pharmacyms.category.CategoryService;
import com.cb008101.pharmacyms.customers.CustomerService;
import com.cb008101.pharmacyms.pharmaitems.Items;
import com.cb008101.pharmacyms.pharmaitems.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerWebController
{
    @Autowired
    private CustomerService customerService;



    @GetMapping("/viewCustomers")
    public String getAllDrugs(Model model)
    {
        model.addAttribute("customer", customerService.getAllCustomers());
        return "customers/view_customers";
    }



    @GetMapping("/deletecustomer/{id}")
    public String deletePharmaItem(@PathVariable("id") Integer id, Model model)
    {
        customerService.deleteCustomer(id);
        return "redirect:/viewCustomers";
    }

}
