package com.example.cookik_app.model;

import java.util.Date;

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

    public Book() {
    }

    public Book(String name, String img, Integer rate, String author, Date create_date, Date read_date, String review, Shelf shelf) {
        this.name = name;
        this.img = img;
        this.rate = rate;
        this.author = author;
        this.create_date = create_date;
        this.read_date = read_date;
        this.review = review;
        this.shelf = shelf;
    }

    public Book(Integer id, String name, String img, Integer rate, String author, Date create_date, Date read_date, String review, Shelf shelf) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.rate = rate;
        this.author = author;
        this.create_date = create_date;
        this.read_date = read_date;
        this.review = review;
        this.shelf = shelf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getRead_date() {
        return read_date;
    }

    public void setRead_date(Date read_date) {
        this.read_date = read_date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", '" + name + '\'' +
                ", '" + author + '\'' +
                ", " + create_date +
                ", " + read_date +
                ", '" + review + '\'' +
                ", " + shelf +
                '}';
    }
}
