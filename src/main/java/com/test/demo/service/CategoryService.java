package com.test.demo.service;

import com.test.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategory();
    public Category findCategoryById (Long Id);
    public  void createCategory( Category category);
    public  void updateCategory (Category category);
    public  void deleteCategory(Long id);
}
