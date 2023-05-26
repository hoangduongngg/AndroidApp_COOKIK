package com.example.bookserice.controller;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.entity.Shelf;
import com.example.bookserice.repository.ShelfRepository;
import com.example.bookserice.service.BookService;
import com.example.bookserice.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shelf", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ShelfRestController {

    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private ShelfService shelfService;

    @GetMapping("")
    public ResponseEntity<List<Shelf>> listBook () {
        List<Shelf> shelves = shelfRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(shelves);
    }

    @GetMapping("{id}")
    public ResponseEntity<Shelf> getById (@PathVariable Integer id) {
        Shelf shelf = shelfRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(shelf);
    }

    @PostMapping("/")
    public ResponseEntity<Shelf> getByName (@RequestParam String name) {
        Shelf shelf = shelfRepository.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(shelf);
    }
}
