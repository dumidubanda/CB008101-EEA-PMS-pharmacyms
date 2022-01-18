package com.cb008101.pharmacyms.category;


import com.cb008101.pharmacyms.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    void addCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategory(Integer id);

    Optional<Category> updateCategory(Integer id, Category category);

    Category getCategorytByID(Integer id);
}
