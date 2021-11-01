package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.dto.*;
import com.example.bcheckapi.model.SearchedBook;
import com.example.bcheckapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /**
     * 도서 보유자 조건 조회
     * @param word (도서명 or isbn)
     */
    public BookSearchResponse searchBookList(String word) {
        try {
            List<BookEntity> bookEntities = bookRepository.searchAllByWord(word);
            return new BookSearchResponse(200, "도서 조회 성공", makeBookWithOwners(bookEntities));
        } catch(Exception e) {
            e.printStackTrace();
            return new BookSearchResponse(500, "도서 조회 실패", null);
        }
    }

    private List<SearchedBook> makeBookWithOwners(List<BookEntity> books) {
        Map<String, SearchedBook> map = new HashMap<>();
        for (BookEntity book : books) {
            SearchedBook response;
            if (map.containsKey(book.getIsbn())) {
                response = map.get(book.getIsbn());
                response.addOwner(book);
            } else {
                response = new SearchedBook(book);
            }
            map.put(book.getIsbn(), response);
        }

        return new ArrayList<>(map.values());
    }

    // 내 도서 조회

    // 도서 보유자 등록
    public GeneralResponse registerBook(BookRegisterRequest req) {
        try {
            bookRepository.save(new BookEntity(req));
            return new GeneralResponse(200, "도서 등록 성공");
        } catch(Exception e) {
            e.printStackTrace();
            return new GeneralResponse(500, "도서 등록 중 에러가 발생하였습니다.");
        }
    }

    // 도서 보유자 수정
    public GeneralResponse changeBookOwner(BookOwnerChangeRequest request) {
        try {
            // 도서 찾기 by id
            BookEntity book = bookRepository.findByIdAndDelYn(request.getId(), "N");
            if (book != null) {
                // book owner 변경
                book.setOwnerEmail(request.getOwnerEmail());
                book.setOwnerName(request.getOwnerName());
                return new GeneralResponse(200, "도서 소유자 수정 성공");
            }

            return new GeneralResponse(404, "수정하고자 하는 도서를 찾을 수 없습니다.");
        } catch(Exception e) {
            e.printStackTrace();
            return new GeneralResponse(500, "도서 소유자 수정 중 에러가 발생하였습니다.");
        }
    }

    // 도서 보유자 삭제 (삭제 여부 수정)
    public GeneralResponse removeBook(BookRemoveRequest request) {
        try {
            BookEntity book = bookRepository.findByIdAndDelYn(request.getId(), "N");
            if (book != null) {
                // book 삭제 여부 수정
                book.setDelYn("Y");
                book.setDelCd(request.getDelCd());
                book.setDelNm(request.getDelNm());
                book.setDelMsg(request.getDelMsg());
                return new GeneralResponse(200, "도서 삭제 성공");
            }

            return new GeneralResponse(404, "삭제하고자 하는 도서가 존재하지 않습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return new GeneralResponse(500, "도서 삭제 중 에러가 발생하였습니다.");
        }
    }
}
