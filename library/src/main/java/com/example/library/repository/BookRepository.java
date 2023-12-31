package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
//    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
//
//    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);

    @Query(value = "select o from book o where id in (:book_ids)",nativeQuery = true)
    List<Book> findBooksByBookIds (@Param("book_ids") List<Long> bookId);
}
