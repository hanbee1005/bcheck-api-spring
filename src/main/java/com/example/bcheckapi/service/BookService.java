package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.dto.BookOwnerChangeRequest;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.dto.BookRemoveRequest;
import com.example.bcheckapi.dto.BookSearchResponse;
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
    public List<BookSearchResponse> searchBookList(String word) {
        try {
            List<BookEntity> bookEntities = bookRepository.searchAllByWord(word);
            return makeBookWithOwners(bookEntities);
        } catch(Exception e) {
            // TODO: error throw 방식 적용...
            e.printStackTrace();
            return null;
        }
    }

    private List<BookSearchResponse> makeBookWithOwners(List<BookEntity> books) {
        Map<String, BookSearchResponse> map = new HashMap<>();
        for (BookEntity book : books) {
            BookSearchResponse response;
            if (map.containsKey(book.getIsbn())) {
                response = map.get(book.getIsbn());
                response.addOwner(book);
            } else {
                response = new BookSearchResponse(book);
            }
            map.put(book.getIsbn(), response);
        }

        return new ArrayList<>(map.values());
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
    public void changeBookOwner(BookOwnerChangeRequest request) {
        try {
            // 도서 찾기 by id
            BookEntity book = bookRepository.findByIdAndDelYn(request.getId(), "N");
            if (book != null) {
                // book owner 변경
                book.setOwnerEmail(request.getOwnerEmail());
                book.setOwnerName(request.getOwnerName());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 도서 보유자 삭제 (삭제 여부 수정)
    public void removeBook(BookRemoveRequest request) {
        try {
            BookEntity book = bookRepository.findByIdAndDelYn(request.getId(), "N");
            if (book != null) {
                // book 삭제 여부 수정
                book.setDelYn("Y");
                book.setDelCd(request.getDelCd());
                book.setDelNm(request.getDelNm());
                book.setDelMsg(request.getDelMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
