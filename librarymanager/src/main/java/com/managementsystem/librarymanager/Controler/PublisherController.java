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

import com.managementsystem.librarymanager.Models.Publisher;
import com.managementsystem.librarymanager.Service.PublisherService;

@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

        @GetMapping("/all")
    public ResponseEntity<List<Publisher>> getAll(){
        List<Publisher> Publishers = publisherService.getAllPublishers();
        return new ResponseEntity<>(Publishers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable Integer id){
        Publisher Publisher = publisherService.getPublisherById(id);
        if(Publisher == null){
            return new ResponseEntity<>(Publisher, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Publisher, HttpStatus.OK);
    }

    @PostMapping("/add/publisher")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher){
        String message = publisherService.savePublisher(publisher);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    
}
