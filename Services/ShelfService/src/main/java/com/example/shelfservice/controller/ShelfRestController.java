package com.example.shelfservice.controller;

import com.example.shelfservice.model.Shelf;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shelf", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ShelfRestController {
//    @Autowired
//    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Shelf>> checkout () {
        List<Shelf> books = null;
        if (true){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }
    }
}
