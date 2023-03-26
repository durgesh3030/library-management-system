package com.test.demo.controller;

import com.test.demo.entity.Category;
import com.test.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @RequestMapping("/categories")
    @ResponseBody
    public List<Category> getAllCategory(){
        return categoryService.findAllCategory ();
    }
    @RequestMapping("category/{id}")
    @ResponseBody
    public Category getCategoryById( @PathVariable("id")Long id ){
        return categoryService.findCategoryById (id);
    }
    @RequestMapping(value = "categories/create",method = RequestMethod.POST)
    @ResponseBody
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory (category);
        return  "Category created successfully";
    }
    @RequestMapping(value = "/categories/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updateCategory(@RequestBody Category category){
        categoryService.updateCategory (category);
        return "Category updated successfully";
    }
    @RequestMapping(value = "/categories/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "Category Delete successfully";
    }


}
