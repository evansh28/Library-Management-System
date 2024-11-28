package com.managementsystem.librarymanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.librarymanager.Models.Book;
import com.managementsystem.librarymanager.Repository.BookReposetory;

@Service
public class BookService {

    @Autowired
    private BookReposetory bookReposetory;

    public List<Book> getAllBooks(){
        return bookReposetory.findAll();
    }

    public Book getBookById(Integer id){
        return bookReposetory.findById(id).orElse(null);
    }

    public String addBook(Book book){


        bookReposetory.save(book);
        return "Seccess";
    }
    
}
