package com.example.bcheckapi.repository;

import com.example.bcheckapi.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b where b.title like %:word% or b.isbn like %:word%")
    List<BookEntity> searchAllByWord(@Param("word") String word);
}
