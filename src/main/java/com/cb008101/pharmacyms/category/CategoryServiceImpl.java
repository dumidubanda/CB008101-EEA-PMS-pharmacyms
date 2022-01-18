package com.cb008101.pharmacyms.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories()
    {
        List<Category> catList = new ArrayList<>();
        categoryRepository.findAll().forEach(catList::add);
        return catList;
    }

    @Override
    public void deleteCategory(Integer id)
    {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Category> updateCategory(Integer id, Category category)
    {
        return categoryRepository.findById(id).map(e ->
        {
            e.setCategory_name(category.getCategory_name());
            return e;
        });
    }

    @Override
    public Category getCategorytByID(Integer id)
    {
        Optional<Category> cat = Optional.ofNullable(categoryRepository.
                findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID")));
        Category category = cat.get();
        return category;
    }


}
