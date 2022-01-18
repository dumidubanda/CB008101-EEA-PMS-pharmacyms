package com.cb008101.pharmacyms.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/addCategory")
    public void addCategory(@RequestBody Category category)
    {
        categoryService.addCategory(category);
    }

    @RequestMapping("/getAllCategories")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCategory/{id}")
    public void updateCategory(@PathVariable Integer id, @RequestBody Category category)
    {
        categoryService.updateCategory(id, category);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCategory/{id}")
    public void deleteCategory(@PathVariable Integer id)
    {
        categoryService.deleteCategory(id);
    }
}
