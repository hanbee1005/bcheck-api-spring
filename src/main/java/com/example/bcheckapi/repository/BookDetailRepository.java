package com.example.bcheckapi.repository;

import com.example.bcheckapi.domain.BookDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDetailRepository extends JpaRepository<BookDetailEntity, String> {

    List<BookDetailEntity> findDistinctByTitleContainsOrIsbnContains(String title, String isbn);

}
