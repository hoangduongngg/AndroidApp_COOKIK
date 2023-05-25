package com.example.bookserice.service;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.BookRequest;
import com.example.bookserice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookServiceImp implements BookService{
    @Autowired
    private BookAdapter adapter;
    @Autowired
    private BookRepository bookRepository;
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
}
