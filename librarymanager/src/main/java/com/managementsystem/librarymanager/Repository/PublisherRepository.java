package com.managementsystem.librarymanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managementsystem.librarymanager.Models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    
}
