package com.example.bookserice.repository;

import com.example.bookserice.model.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
    Shelf findByName(String name);
}
