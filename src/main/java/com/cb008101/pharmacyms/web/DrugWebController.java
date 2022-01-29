package com.cb008101.pharmacyms.web;


import com.cb008101.pharmacyms.brand.BrandService;
import com.cb008101.pharmacyms.category.CategoryService;
import com.cb008101.pharmacyms.pharmaitems.DrugItemsService;
import com.cb008101.pharmacyms.pharmaitems.Items;
//import com.cb008101.pharmacyms.racks.RackService;
//import com.cb008101.pharmacyms.suppliers.SupplierService;
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
public class DrugWebController {
    @Autowired
    private DrugItemsService drugItemsService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

//    @Autowired
//    private RackService rackService;
//
//    @Autowired
//    private SupplierService supplierService;

    @GetMapping("/viewDrugs")
    public String getAllDrugs(Model model){
        model.addAttribute("drug", drugItemsService.getAllByNames());
        return "pharmaitems/view_pharma_item";
    }

    @GetMapping("/showAddDrugForm")
    public String showAddDrugForm(Items items, Model model){
        model.addAttribute("brand", brandService.getAllBrands());
        model.addAttribute("category", categoryService.getAllCategories());
//        model.addAttribute("rack", rackService.getAllRacks());
//        model.addAttribute("supplier", supplierService.getAllSuppliers());
        return "pharmaitems/add_pharma_items";
    }

    @PostMapping("/addNewDrug")
    public String addNewDrug(@Valid Items items, BindingResult result, Model model){
        if(result.hasErrors()){
            return  "pharmaitems/add_pharma_items";
        }
        drugItemsService.saveDrug(items);
        return "redirect:/viewDrugs";
    }

    @GetMapping("/showUpdateDrugForm/{id}")
    public String showEditDrugForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("drugs", drugItemsService.getByID(id));
        return "pharmaitems/edit_pharma_item";
    }

    @PostMapping("/updateDrug/{id}")
    public String updateDrug(@PathVariable ("id") Integer id, @Valid Items items, BindingResult result, Model model){
        if(result.hasErrors()){
            items.setDrugID(id);
            model.addAttribute("items", items);
            return "pharmaitems/edit_pharma_item";
        }
        Optional<Items> drugs1 = drugItemsService.updateDrug(id, items);
        return "redirect:/viewDrugs";
    }

    @GetMapping("/deleteDrug/{id}")
    public String deleteDrug(@PathVariable ("id") Integer id, Model model) {
        drugItemsService.deleteDrug(id);
        return "redirect:/viewDrugs";
    }

}
