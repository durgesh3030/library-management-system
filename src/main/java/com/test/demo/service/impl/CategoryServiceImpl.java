package com.test.demo.service.impl;

import com.test.demo.entity.Category;
import com.test.demo.exception.NotFoundException;
import com.test.demo.repository.CategoryRepository;
import com.test.demo.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryServiceImpl ( CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> findAllCategory () {
        return categoryRepository.findAll ();
    }
    @Transactional(readOnly = true, propagation =Propagation.SUPPORTS)
    @Override
    public Category findCategoryById(Long id){
        return categoryRepository.findById (id)
                .orElseThrow (()-> new NotFoundException (String.format ("Category not found with ID %d", id)));
    }
    @Override
    public  void createCategory(Category category){
        categoryRepository.save(category);
    }
     @Override
     public void updateCategory(Category category){
        categoryRepository.save (category);
     }
     @Override
       public void deleteCategory(Long id){
          var category = categoryRepository.findById (id)
                  .orElseThrow (()-> new NotFoundException (String.format ("Category not found  with ID %d", id)));
        categoryRepository.deleteById (category.getId ());
     }

}
