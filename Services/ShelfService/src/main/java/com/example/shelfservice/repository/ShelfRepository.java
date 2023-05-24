package com.example.shelfservice.repository;

import com.example.shelfservice.model.entity.ShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<ShelfEntity, Integer> {

}
