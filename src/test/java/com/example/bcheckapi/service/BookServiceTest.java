package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@DisplayName("도서 서비스 테스트")
@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired BookService bookService;
    @Autowired BookRepository bookRepository;

    @Test
    @DisplayName("도서 등록")
    void registerBook() {
        // Given
        BookRegisterRequest request = new BookRegisterRequest();
        request.setEmail("test1@gmail.com");
        request.setName("테스터1");

        BookInfo bookInfo = new BookInfo();
        bookInfo.setTitle("토비의 스프링 3.1 세트 (스프링의 이해와 원리 + 스프링의 기술과 선택, 전2권)");
        bookInfo.setLink("http://book.naver.com/bookdb/book_detail.php?bid=7006516");
        bookInfo.setImage("https://bookthumb-phinf.pstatic.net/cover/070/065/07006516.jpg?type=m1&udate=20151005");
        bookInfo.setAuthor("이일민");
        bookInfo.setPrice("75000");
        bookInfo.setDiscount("67500");
        bookInfo.setPublisher("에이콘출판");
        bookInfo.setPubdate("20120921");
        bookInfo.setIsbn("8960773433 9788960773431");
        bookInfo.setDescription("『토비의 스프링 3.1』은 스프링을 처음 접하거나 스프링을 경험했지만 스프링이 어렵게 느껴지는 개발자부터 스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블이다.[Vol. 1 스프링의 이해와 원리] 단순한 예제를... ");

        request.setBookInfo(bookInfo);

        // When
        bookService.registerBook(request);

        // Then
    }
}