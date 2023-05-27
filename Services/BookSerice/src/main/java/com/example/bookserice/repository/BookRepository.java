package com.example.bookserice.repository;

import com.example.bookserice.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByShelfId(Integer shelfId);
    List<BookEntity> findByNameContains (String name);
    List<BookEntity> findByAuthorContains(String author);

//    List<BookEntity> findByNameContainsAndAuthorContains (String key, String kee);

    List<BookEntity> findByRate (Integer rate);
    List<BookEntity> findByNameLikeAndRateAndAuthorLikeAndShelfId (
            String name,
            Integer rate,
            String author,
//            Date start_date, Date end_date,
//            Date start_read, Date end_read,
            Integer shelfId);
//
//    List<BookEntity> findByCreate_dateBetween (Date start_date, Date end_date);
//    List<BookEntity> findByRead_dateBetween (Date start_date, Date end_date);

}
