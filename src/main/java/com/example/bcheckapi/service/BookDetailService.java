package com.example.bcheckapi.service;

import com.example.bcheckapi.repository.BookDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;

    // isbn 별 도서 등록

    // isbn으로 도서 정보 조회
}
