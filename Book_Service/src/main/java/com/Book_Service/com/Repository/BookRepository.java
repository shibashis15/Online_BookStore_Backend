package com.Book_Service.com.Repository;

import com.Book_Service.com.Model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByCategoriesInOrderByRating(Set<String> categorySet);
    public List<Book> findAllByOrderByRatingDesc();
    public List<Book> findAllByOrderByNumberOfCopiesSoldDesc();

}
