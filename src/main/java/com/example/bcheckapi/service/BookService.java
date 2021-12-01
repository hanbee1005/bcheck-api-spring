package com.example.bcheckapi.service;

import com.example.bcheckapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 도서 등록

    // 도서 조회 (서적명, 회원명, 출판사, 저자 검색)

    // 도서 소유자 변경

    // 도서 삭제 (del_yn 변경)
}
