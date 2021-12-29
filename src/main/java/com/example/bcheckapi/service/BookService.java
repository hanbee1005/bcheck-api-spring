package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookDetailEntity;
import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.dto.BookSearchResponse;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.model.OwnerInfo;
import com.example.bcheckapi.repository.BookDetailRepository;
import com.example.bcheckapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookDetailRepository bookDetailRepository;

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
    public List<BookSearchResponse> searchBookList(String word) {
        List<BookDetailEntity> bookDetails = bookDetailRepository.findDistinctByTitleContainsOrIsbnContains(word, word);
        List<BookSearchResponse> response = new ArrayList<>();
        bookDetails.forEach(details -> {
            BookSearchResponse res = new BookSearchResponse();
            res.setBookInfo(BookInfo.builder()
                    .title(details.getTitle())
                    .link(details.getLink())
                    .image(details.getImage())
                    .author(details.getAuthor())
                    .price(details.getPrice())
                    .discount(details.getDiscount())
                    .publisher(details.getPublisher())
                    .pubdate(details.getPubdate())
                    .isbn(details.getIsbn())
                    .description(details.getDescription())
                    .build());

            List<OwnerInfo> owners = new ArrayList<>();

            details.getBooks().forEach(owner -> {
                owners.add(OwnerInfo.builder()
                        .bookId(owner.getId())
                        .email(owner.getMember().getEmail())
                        .name(owner.getMember().getName())
                        .ownDate(owner.getOwnDt())
                        .delYn(owner.getDelYn())
                        .build());
            });

            res.setOwners(owners);
            response.add(res);
        });

        return response;
    }

    // 도서 소유자 변경

    // 도서 삭제 (del_yn 변경)
}
