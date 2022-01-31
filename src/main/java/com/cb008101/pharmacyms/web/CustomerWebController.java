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

//    @Autowired
//    private BrandService brandService;
//
//    @Autowired
//    private CategoryService categoryService;

//    @Autowired
//    private RackService rackService;
//
//    @Autowired
//    private SupplierService supplierService;

    @GetMapping("/viewCustomers")
    public String getAllDrugs(Model model)
    {
        model.addAttribute("customer", customerService.getAllCustomers());
        return "customers/view_customers";
    }

//    @GetMapping("/showAddDrugForm")
//    public String showAddDrugForm(Items items, Model model)
//    {
////        model.addAttribute("brand", brandService.getAllBrands());
////        model.addAttribute("category", categoryService.getAllCategories());
////        model.addAttribute("rack", rackService.getAllRacks());
////        model.addAttribute("supplier", supplierService.getAllSuppliers());
//        return "customers/view_customers";
//    }

//    @PostMapping("/addNewDrug")
//    public String addNewDrug(@Valid Items items, BindingResult result, Model model)
//    {
//        if (result.hasErrors())
//        {
//            return "pharmaitems/add_pharma_items";
//        }
//        customerService.saveDrug(items);
//        return "redirect:/viewDrugs";
//    }

//    @GetMapping("/showUpdateDrugForm/{id}")
//    public String showEditDrugForm(@PathVariable("id") Integer id, Model model)
//    {
//        model.addAttribute("drugs", customerService.getByID(id));
//
//        //added now
////        model.addAttribute("brand", brandService.getAllBrands());
////        model.addAttribute("category", categoryService.getAllCategories());
//
//        return "customers/view_customers";
//    }

//    @PostMapping("/updateDrug/{id}")
//    public String updateDrug(@PathVariable("id") Integer id, @Valid Items items, BindingResult result, Model model)
//    {
//        if (result.hasErrors())
//        {
//            items.setDrugID(id);
//            model.addAttribute("items", items);
//            return "customers/view_customers";
//        }
//        Optional<Items> drugs1 = customerService.updateCustomer(id, items);
//        return "redirect:/viewDrugs";
//    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteDrug(@PathVariable("id") Integer id, Model model)
    {
        customerService.deleteCustomer(id);
        return "redirect:/viewCustomers";
    }

}
