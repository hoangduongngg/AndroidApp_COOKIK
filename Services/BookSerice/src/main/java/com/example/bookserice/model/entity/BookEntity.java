package com.example.bookserice.model.entity;

import com.example.bookserice.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String img;
    @Column(nullable = true)
    private Integer rate;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Date create_date;
    @Column(nullable = true)
    private Date read_date;
    @Column(nullable = true)
    private String review;
    @Column(nullable = false)
    private Integer shelfId;
}
