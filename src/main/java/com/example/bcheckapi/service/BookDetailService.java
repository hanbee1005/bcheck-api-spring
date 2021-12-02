package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookDetailEntity;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.repository.BookDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;

    /**
     * isbn 별 도서 등록
     * @param info
     * @return
     */
    public BookDetailEntity addBookInfo(BookInfo info) {
        if (bookDetailRepository.findById(info.getIsbn()).isEmpty()) {
            BookDetailEntity entity = BookDetailEntity.builder().bookInfo(info).build();
            bookDetailRepository.save(entity);
        }

        return searchBookInfo(info.getIsbn());
    }

    /**
     * isbn으로 도서 정보 조회
     * @param isbn
     * @return
     */
    public BookDetailEntity searchBookInfo(String isbn) {
        return bookDetailRepository.findById(isbn).orElse(null);
    }

    // 도서명으로 검색
}
