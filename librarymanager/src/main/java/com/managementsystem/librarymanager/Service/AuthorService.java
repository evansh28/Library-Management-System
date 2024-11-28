package com.managementsystem.librarymanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.librarymanager.Models.Author;
import com.managementsystem.librarymanager.Repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Integer id){
        return authorRepository.findById(id).orElse(null);
    }

    public String saveAuther(Author author){
        authorRepository.save(author);
        return "Success";
    }

    public void deleteAuthor(Integer id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Auther Already Deleted"));
        authorRepository.delete(author);
    }
    
}
