package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /**
     * 도서 보유자 조건 조회
     * @param word (도서명 or 저자명 or isbn)
     */
    public void searchBookList(String word) {

    }

    // 내 도서 조회

    // 도서 보유자 등록
    public void registerBook(BookRegisterRequest req) {
        try {
            bookRepository.save(new BookEntity(req));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 도서 보유자 수정

    // 도서 보유자 삭제 (삭제 여부 수정)
}
