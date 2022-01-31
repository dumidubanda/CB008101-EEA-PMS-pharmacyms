package com.cb008101.pharmacyms.web;


import com.cb008101.pharmacyms.category.Category;
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
public class CategoryWebController
{
    @Autowired
    CategoryService categoryService;


    @GetMapping("/viewCategories")
    public String viewCategories(Model model)
    {
        model.addAttribute("category", categoryService.getAllCategories());
        return "category/view_category";
    }

    @GetMapping("/showAddCategoryForm")
    public String showAddPharmacistForm(Category category)
    {
        return "category/add_category";
    }

    @PostMapping("/addNewCategory")
    public String addNewCategory(@Valid Category category, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "category/add_category";
        }
        categoryService.addCategory(category);
        return "redirect:/viewCategories";
    }

    @GetMapping("/showUpdateCategoryForm/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("category", categoryService.getCategorytByID(id));
        return "category/edit_category";
    }

    @PostMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") Integer id, @Valid Category category, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            category.setCategoryID (id);
            model.addAttribute("category", category);
            return "category/edit_category";
        }
        Optional<Category> category1 = categoryService.updateCategory(id, category);
        return "redirect:/viewCategories";
    }


    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, Model model)
    {
        categoryService.deleteCategory(id);
        return "redirect:/viewCategories";
    }
}
