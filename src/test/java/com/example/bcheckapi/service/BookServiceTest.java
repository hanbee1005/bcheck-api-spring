package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.dto.BookOwnerChangeRequest;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.dto.BookRemoveRequest;
import com.example.bcheckapi.dto.BookSearchResponse;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayName("도서 서비스 테스트")
@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired BookService bookService;
    @Autowired BookRepository bookRepository;

    @BeforeEach
    void init() {
        String[] book1 = {
                "test1@gmail.com",
                "테스터1",
                "토비의 스프링 3.1 세트 (스프링의 이해와 원리 + 스프링의 기술과 선택, 전2권)",
                "http://book.naver.com/bookdb/book_detail.php?bid=7006516",
                "https://bookthumb-phinf.pstatic.net/cover/070/065/07006516.jpg?type=m1&udate=20151005",
                "이일민",
                "75000",
                "67500",
                "에이콘출판",
                "20120921",
                "8960773433 9788960773431",
                "『토비의 스프링 3.1』은 스프링을 처음 접하거나 스프링을 경험했지만 스프링이 어렵게 느껴지는 개발자부터 스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블이다.[Vol. 1 스프링의 이해와 원리] 단순한 예제를... "
        };

        String[] book2 = {
                "test1@gmail.com",
                "테스터1",
                "자바 ORM 표준 JPA 프로그래밍 (에이콘 오픈 소스 프로그래밍 시리즈,스프링 데이터 예제 프로젝트로 배우는 전자정부 표준 데이터베이스 프레임워크)",
                "http://book.naver.com/bookdb/book_detail.php?bid=9252528",
                "https://bookthumb-phinf.pstatic.net/cover/092/525/09252528.jpg?type=m1&udate=20200721",
                "김영한",
                "43000",
                "38700",
                "에이콘출판",
                "20150728",
                "8960777331 9788960777330",
                "자바 ORM 표준 JPA는 SQL 작성 없이 객체를 데이터베이스에 직접 저장할 수 있게 도와주고, 객체와 관계형 데이터베이스의 차이도 중간에서 해결해준다. 이 책은 JPA 기초 이론과 핵심 원리, 그리고 실무에 필요한 성능 최적화 방법까지 JPA에 대한 모든 것을 다룬다. 또한... "
        };

        String[] book3 = {
                "test2@gmail.com",
                "테스터2",
                "토비의 스프링 3.1 세트 (스프링의 이해와 원리 + 스프링의 기술과 선택, 전2권)",
                "http://book.naver.com/bookdb/book_detail.php?bid=7006516",
                "https://bookthumb-phinf.pstatic.net/cover/070/065/07006516.jpg?type=m1&udate=20151005",
                "이일민",
                "75000",
                "67500",
                "에이콘출판",
                "20120921",
                "8960773433 9788960773431",
                "『토비의 스프링 3.1』은 스프링을 처음 접하거나 스프링을 경험했지만 스프링이 어렵게 느껴지는 개발자부터 스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블이다.[Vol. 1 스프링의 이해와 원리] 단순한 예제를... "
        };

        bookRepository.save(new BookEntity(setBookRegisterRequest(book1)));
        bookRepository.save(new BookEntity(setBookRegisterRequest(book2)));
        bookRepository.save(new BookEntity(setBookRegisterRequest(book3)));
    }

    private BookRegisterRequest setBookRegisterRequest(String[] info) {
        BookRegisterRequest request = new BookRegisterRequest();
        request.setEmail(info[0]);
        request.setName(info[1]);

        BookInfo bookInfo = new BookInfo();
        bookInfo.setTitle(info[2]);
        bookInfo.setLink(info[3]);
        bookInfo.setImage(info[4]);
        bookInfo.setAuthor(info[5]);
        bookInfo.setPrice(info[6]);
        bookInfo.setDiscount(info[7]);
        bookInfo.setPublisher(info[8]);
        bookInfo.setPubdate(info[9]);
        bookInfo.setIsbn(info[10]);
        bookInfo.setDescription(info[11]);

        request.setBookInfo(bookInfo);

        return request;
    }

    @Test
    @DisplayName("도서 조회 - 제목, ISBN 검색")
    void searchBookList() {
        // Given
        String emptyWord = "";
        String titleWord = "토비";
        String isbnWord = "9788960777330";

        // When
        List<BookSearchResponse> bookListWithEmptyWord = bookService.searchBookList(emptyWord);
        List<BookSearchResponse> bookListWithTitleWord = bookService.searchBookList(titleWord);
        List<BookSearchResponse> bookListWithIsbnWord = bookService.searchBookList(isbnWord);

        // Then
        assertThat(bookListWithEmptyWord.size()).isEqualTo(2);

        assertThat(bookListWithTitleWord.size()).isEqualTo(1);
        assertThat(bookListWithTitleWord.get(0).getTitle()).isEqualTo("토비의 스프링 3.1 세트 (스프링의 이해와 원리 + 스프링의 기술과 선택, 전2권)");

        assertThat(bookListWithIsbnWord.size()).isEqualTo(1);
        assertThat(bookListWithIsbnWord.get(0).getIsbn()).isEqualTo("8960777331 9788960777330");
    }

    @Test
    @DisplayName("도서 소유자 변경")
    void changeBookOwner() {
        // Given
        List<BookEntity> books = bookRepository.findAll();
        Long id = books.get(0).getId();

        BookOwnerChangeRequest request = new BookOwnerChangeRequest();
        request.setId(id);
        request.setOwnerEmail("test3@gmail.com");
        request.setOwnerName("테스터3");

        // When
        bookService.changeBookOwner(request);

        // Then
        BookEntity book = bookRepository.findById(id).orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getOwnerEmail()).isEqualTo(request.getOwnerEmail());
        assertThat(book.getOwnerName()).isEqualTo(request.getOwnerName());
    }

    @Test
    @DisplayName("도서 삭제 여부 변경")
    void removeBook() {
        // Given
        List<BookEntity> books = bookRepository.findAll();
        Long id = books.get(0).getId();

        BookRemoveRequest request = new BookRemoveRequest();
        request.setId(id);
        request.setDelCd("D01");
        request.setDelNm("분실");
        request.setDelMsg(null);

        // When
        bookService.removeBook(request);

        // Then
        BookEntity book = bookRepository.findById(id).orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getDelYn()).isEqualTo("Y");
        assertThat(book.getDelCd()).isEqualTo(request.getDelCd());
    }
}