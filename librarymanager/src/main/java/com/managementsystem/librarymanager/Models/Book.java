package com.managementsystem.librarymanager.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String bookName;

    @ManyToMany
    private List<Author> author;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Publisher> publishers; 

}
