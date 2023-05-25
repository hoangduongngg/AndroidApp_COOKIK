package com.example.bookserice.model;
import com.example.bookserice.model.entity.Shelf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String img;
    private Integer rate;
    private String author;
    private Date create_date;
    private Date read_date;
    private String review;
    private Shelf shelf;
}
