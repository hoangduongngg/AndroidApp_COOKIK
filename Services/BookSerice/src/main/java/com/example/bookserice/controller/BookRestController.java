package com.example.bookserice.controller;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.BookRequest;
import com.example.bookserice.repository.BookRepository;
import com.example.bookserice.service.BookAdapter;
import com.example.bookserice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BookRestController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookAdapter adapter;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<Book>> listBook () {
        List<Book> books = adapter.adapter_list(bookRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById (@PathVariable Integer id) {
        Book book = adapter.adapter(bookRepository.findById(id).get());
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
//    @PostMapping("/key")
//    public ResponseEntity<List<Book>> getByKey (
//            @RequestParam String key
//    ) {
//        List<Book> books = adapter.adapter_list(bookRepository.findByNameContainsAndAuthorContains(key));
//        return ResponseEntity.status(HttpStatus.OK).body(books);
//    }

    @PostMapping("/name")
    public ResponseEntity<List<Book>> getByName (
            @RequestParam String name
    ) {
        System.out.println(name);
        List<Book> books = adapter.adapter_list(bookRepository.findByNameContains(name));
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping("/author")
    public ResponseEntity<List<Book>> getByAuthor (
            @RequestParam String author
    ) {
        List<Book> books = adapter.adapter_list(bookRepository.findByAuthorContains(author));
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping("/rate")
    public ResponseEntity<List<Book>> getByRate (
            @RequestParam Integer rate
    ) {
        List<Book> books = adapter.adapter_list(bookRepository.findByRate(rate));
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping("/shelf")
    public ResponseEntity<List<Book>> getByShelf (@RequestParam Integer id) {
        List<Book> books = adapter.adapter_list(bookRepository.findByShelfId(id));
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBook (
            @RequestBody Book book
    ) {
        try {
            System.out.println(book);
            book = bookService.addBook(book);
            System.out.println("After: " + book);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> update (
            @RequestBody Book book
    ) {
        try {
            System.out.println(book);
            book = bookService.update(book);
            System.out.println("Update: " + book);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> delete (
            @RequestBody Book book
    ) {
        try {
            System.out.println(book);
            book = bookService.delete(book);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

//    @PostMapping("")
//    public ResponseEntity<List<Book>> getByObject (
//            @RequestBody BookRequest bookRequest) {
//        List<Book> books = bookService.getListByObject(bookRequest);
//        return ResponseEntity.status(HttpStatus.OK).body(books);
//    }
}
