package com.managementsystem.librarymanager.Controler;

import java.util.ArrayList;
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
import com.managementsystem.librarymanager.Models.Book;
import com.managementsystem.librarymanager.Models.Category;
import com.managementsystem.librarymanager.Models.Publisher;
import com.managementsystem.librarymanager.Service.AuthorService;
import com.managementsystem.librarymanager.Service.BookService;
import com.managementsystem.librarymanager.Service.CategoryService;
import com.managementsystem.librarymanager.Service.PublisherService;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

        @Autowired
    private PublisherService publisherService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

        @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> Books = bookService.getAllBooks();
        return new ResponseEntity<>(Books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id){
        Book Book = bookService.getBookById(id);
        if(Book == null){
            return new ResponseEntity<>(Book, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Book, HttpStatus.OK);
    }

    @PostMapping("/add/book")
    public ResponseEntity<String> addBook(@RequestBody Book book){

        List<Author> authors = new ArrayList<>();

        for(Author author : book.getAuthor()){
            Author foundauthor = authorService.getAuthorById(author.getId());
            if(foundauthor == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            authors.add(foundauthor);
        }
        book.setAuthor(authors);

        List<Publisher> publishers = new ArrayList<>();

        for(Publisher publisher : book.getPublishers()){
            Publisher foundpublisher = publisherService.getPublisherById(publisher.getId());
            if(foundpublisher == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            publishers.add(foundpublisher);
        }
        book.setPublishers(publishers);

        List<Category> categories = new ArrayList<>();

        for(Category category : book.getCategories()){
            Category foundcCategory = categoryService.getCategoryById(category.getId());
            if(foundcCategory == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            categories.add(foundcCategory);
        }
        book.setCategories(categories);

        String message = bookService.addBook(book);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    
}
