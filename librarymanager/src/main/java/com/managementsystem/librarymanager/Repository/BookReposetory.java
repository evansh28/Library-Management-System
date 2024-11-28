package com.managementsystem.librarymanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managementsystem.librarymanager.Models.Book;

public interface BookReposetory extends JpaRepository<Book, Integer> {
    
}
