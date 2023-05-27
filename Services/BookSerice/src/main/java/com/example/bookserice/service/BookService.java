package com.example.bookserice.service;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.BookRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface BookService {
    List<Book> getListByObject (BookRequest bookRequest);
    Book addBook(Book book);
    Book update (Book book);
    Book delete (Book book);



}
