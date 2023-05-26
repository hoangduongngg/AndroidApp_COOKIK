package com.example.bookserice.service;

import com.example.bookserice.model.Book;
import com.example.bookserice.model.entity.BookEntity;
import com.example.bookserice.model.entity.Shelf;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookAdapter {
    public List<Book> adapter_list(List<BookEntity> bookEntityList) {
        List<Book> bookListRes = new ArrayList<>();
        for (BookEntity bookEntity: bookEntityList) {
            bookListRes.add(new BookAdapter().adapter(bookEntity));
        }
        return bookListRes;
    }

    public Book adapter (BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setName(bookEntity.getName());
        book.setImg(bookEntity.getImg());
        book.setRate(bookEntity.getRate());
        book.setAuthor(bookEntity.getAuthor());
        book.setCreate_date(bookEntity.getCreate_date());
        book.setRead_date(bookEntity.getRead_date());
        book.setReview(bookEntity.getReview());
        book.setShelf(getShelfById(bookEntity.getShelfId()));
        return book;
    }

    public BookEntity adapter_toEntity (Book book) {
        BookEntity bookEntity = new BookEntity();
        if (book.getId()!=null) {
            bookEntity.setId(book.getId());
        }
        bookEntity.setName(book.getName());
        bookEntity.setImg(book.getImg());
        bookEntity.setRate(book.getRate());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setCreate_date(book.getCreate_date());
        bookEntity.setRead_date(book.getRead_date());
        bookEntity.setReview(book.getReview());
        bookEntity.setShelfId(book.getShelf().getId());
        return bookEntity;
    }

    private Shelf getShelfById(Integer shelfId) {
        Shelf shelf = new Shelf();

        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8071/api/shelf/{shelfId}";
        try {
            shelf = rest.getForObject(url, Shelf.class, shelfId);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return shelf;
    }
}
