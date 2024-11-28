package com.managementsystem.librarymanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managementsystem.librarymanager.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
