package com.managementsystem.librarymanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managementsystem.librarymanager.Models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
}
