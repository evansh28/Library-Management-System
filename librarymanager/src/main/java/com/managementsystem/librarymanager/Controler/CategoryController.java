package com.managementsystem.librarymanager.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managementsystem.librarymanager.Models.Category;
import com.managementsystem.librarymanager.Service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

        @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> Categorys = categoryService.getAllCategories();
        return new ResponseEntity<>(Categorys, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id){
        Category Category = categoryService.getCategoryById(id);
        if(Category == null){
            return new ResponseEntity<>(Category, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }

    @PostMapping("/add/category")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        String message = categoryService.addCategory(category);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    
}
