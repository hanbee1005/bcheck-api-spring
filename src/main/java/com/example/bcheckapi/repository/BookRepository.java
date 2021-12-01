package com.example.bcheckapi.repository;

import com.example.bcheckapi.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}
