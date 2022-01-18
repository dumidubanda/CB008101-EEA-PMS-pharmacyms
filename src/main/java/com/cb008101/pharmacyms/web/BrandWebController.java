package com.cb008101.pharmacyms.web;

import com.cb008101.pharmacyms.brand.Brand;
import com.cb008101.pharmacyms.brand.BrandService;
import com.cb008101.pharmacyms.category.CategoryService;
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
public class BrandWebController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/viewBrands")
    public String getAllBrands(Model model){
        //model.addAttribute("brand", brandService.getAllBrands());
        model.addAttribute("brand", brandService.getAllCategoryNames());
        return "viewbrands";
    }

    @GetMapping("/showAddBrandForm")
    public String showAddBrandForm(Brand brand, Model model){
        model.addAttribute("category", categoryService.getAllCategories());
        return "addbrand";
    }

    @PostMapping("/addNewBrand")
    public String addNewBrand(@Valid Brand brand, BindingResult result, Model model){
        if(result.hasErrors()){
            return  "addbrand";
        }
        brandService.saveBrand(brand);
        return "redirect:/viewBrands";
    }

    @GetMapping("/showUpdateBrand/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("brand", brandService.getBrandById(id));
        return "editbrands";
    }

    @PostMapping("/updateBrand/{id}")
    public String updateBrand(@PathVariable ("id") Integer id, @Valid Brand brand, BindingResult result, Model model){
        if(result.hasErrors()){
            brand.setBrandID(id);
            model.addAttribute("brand", brand);
            return "editbrands";
        }
        Optional<Brand> brand1 = brandService.updateBrand(brand, id);
        return "redirect:/viewBrands";
    }

    @GetMapping("/deleteBrand/{id}")
    public String deletePharmacist(@PathVariable ("id") Integer id, Model model) {
        brandService.deleteBrand(id);
        return "redirect:/viewBrands";
    }


}
