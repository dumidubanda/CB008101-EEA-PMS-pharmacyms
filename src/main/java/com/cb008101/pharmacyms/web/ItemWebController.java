package com.cb008101.pharmacyms.web;


import com.cb008101.pharmacyms.brand.BrandService;
import com.cb008101.pharmacyms.category.CategoryService;
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
public class ItemWebController
{
    @Autowired
    private ItemsService itemsService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;



    @GetMapping("/viewPharmaItem")
    public String getAllDrugs(Model model)
    {
        model.addAttribute("drug", itemsService.getAllByNames());
        return "pharmaitems/view_pharma_item";
    }

    @GetMapping("/showAddPharmaItemForm")
    public String showAddPharmaItemForm(Items items, Model model)
    {
        model.addAttribute("brand", brandService.getAllBrands());
        model.addAttribute("category", categoryService.getAllCategories());
        return "pharmaitems/add_pharma_items";
    }

    @PostMapping("/addNewPharmaItem")
    public String addNewPharmaItem(@Valid Items items, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "pharmaitems/add_pharma_items";
        }
        itemsService.saveDrug(items);
        return "redirect:/viewPharmaItem";
    }

    @GetMapping("/showUpdatePharmaItemForm/{id}")
    public String showEditDrugForm(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("items", itemsService.getByID(id));

        //added now
        model.addAttribute("brand", brandService.getAllBrands());
        model.addAttribute("category", categoryService.getAllCategories());

        return "pharmaitems/edit_pharma_item";
    }

    @PostMapping("/updatePharmaItem/{id}")
    public String updatePharmaItem(@PathVariable("id") Integer id, @Valid Items items, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            items.setPhItemID(id);
            model.addAttribute("items", items);
            return "pharmaitems/edit_pharma_item";
        }
        Optional<Items> items1 = itemsService.updatePharmaItem(id, items);
        return "redirect:/viewPharmaItem";
    }

    @GetMapping("/deletePharmaItem/{id}")
    public String deletePharmaItem(@PathVariable("id") Integer id, Model model)
    {
        itemsService.deletePharmaItem(id);
        return "redirect:/viewPharmaItem";
    }

}
