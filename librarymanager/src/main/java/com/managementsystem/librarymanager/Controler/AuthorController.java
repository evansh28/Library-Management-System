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

import com.managementsystem.librarymanager.Models.Author;
import com.managementsystem.librarymanager.Service.AuthorService;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAll(){
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Integer id){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return new ResponseEntity<>(author, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/add/author")
    public ResponseEntity<String> addAuthor(@RequestBody Author auther){
        String message = authorService.saveAuther(auther);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    
}
