package com.example.bcheckapi.repository;

import com.example.bcheckapi.domain.BookDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetailEntity, String> {
}
