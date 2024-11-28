package com.managementsystem.librarymanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.librarymanager.Models.Category;
import com.managementsystem.librarymanager.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public String addCategory(Category category){
        categoryRepository.save(category);
        return "Sucess";
    }

    
    

}
