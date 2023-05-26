package com.example.bookserice.service;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.BookRequest;
import com.example.bookserice.model.entity.Shelf;
import com.example.bookserice.repository.BookRepository;
import com.example.bookserice.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class BookServiceImp implements BookService{
    @Autowired
    private BookAdapter adapter;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ShelfRepository shelfRepository;
    @Override
    public List<Book> getListByObject (BookRequest bookRequest) {
        Book book = bookRequest.getBook();
        try {
            return adapter.adapter_list(bookRepository.findByNameLikeAndRateAndAuthorLikeAndShelfId(
                    book.getName(),
                    book.getRate(),
                    book.getAuthor(),
//                    bookRequest.getStart_create(),
//                    bookRequest.getEnd_create(),
//                    bookRequest.getStart_read(),
//                    bookRequest.getEnd_read(),
                    book.getShelf().getId()
            ));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Book addBook(Book book) {
        book.setCreate_date(getCurrentDate());
        System.out.println(book);
        book.setShelf(shelfRepository.findByName(book.getShelf().getName()));
        bookRepository.save(adapter.adapter_toEntity(book));
        return book;
    }

    private Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
}
