package com.example.bookserice.model;

import lombok.Data;

import java.util.Date;

@Data
public class BookRequest {
    private Book book;
    private Date start_create;
    private Date end_create;
    private Date start_read;
    private Date end_read;
}
