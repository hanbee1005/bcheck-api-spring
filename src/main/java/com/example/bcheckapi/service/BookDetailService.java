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
    public String addBookInfo(BookInfo info) {
        if (bookDetailRepository.findById(info.getIsbn()).isEmpty()) {
            BookDetailEntity entity = BookDetailEntity.builder().bookInfo(info).build();
            bookDetailRepository.save(entity);
        }

        return info.getIsbn();
    }

    /**
     * isbn으로 도서 정보 조회
     * @param isbn
     * @return
     */
    public BookInfo searchBookInfo(String isbn) {
        BookDetailEntity searchedBook = bookDetailRepository.findById(isbn).orElse(null);

        if (searchedBook != null) {
            return BookInfo.builder().entity(searchedBook).build();
        }

        return null;
    }
}
