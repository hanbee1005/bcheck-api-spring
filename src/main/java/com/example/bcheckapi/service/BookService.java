package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookDetailEntity;
import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final MemberService memberService;
    private final BookDetailService bookDetailService;

    /**
     * 도서 등록
     * @param request
     * @return
     */
    public String addBook(BookRegisterRequest request) {
        MemberEntity memberEntity = memberService.searchById(request.getEmail());
        BookDetailEntity bookDetailEntity = bookDetailService.addBookInfo(request.getBookInfo());

        BookEntity bookEntity = BookEntity.builder()
                .member(memberEntity)
                .bookDetail(bookDetailEntity)
                .build();

        bookRepository.save(bookEntity);
        return request.getBookInfo().getIsbn();
    }

    // 도서 조회 (서적명, 회원명, 출판사, 저자 검색)

    // 도서 소유자 변경

    // 도서 삭제 (del_yn 변경)
}
