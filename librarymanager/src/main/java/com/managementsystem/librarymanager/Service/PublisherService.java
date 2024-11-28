package com.managementsystem.librarymanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.librarymanager.Models.Publisher;
import com.managementsystem.librarymanager.Repository.PublisherRepository;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

        public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Integer id){
        return publisherRepository.findById(id).orElse(null);
    }

    public String savePublisher(Publisher publisher){
        publisherRepository.save(publisher);
        return "Success";
    }

    public void deletePublisher(Integer id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Auther Already Deleted"));
        publisherRepository.delete(publisher);
    }
    
}
