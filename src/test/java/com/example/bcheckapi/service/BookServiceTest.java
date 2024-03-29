package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired BookService bookService;
    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @BeforeEach
    void init() {
        MemberRegisterRequest request = new MemberRegisterRequest();
        request.setEmail("user@gmail.com");
        request.setName("테스터");
        request.setPassword("1234");

        MemberEntity member = MemberEntity.builder()
                .request(request)
                .passwordEncoder(passwordEncoder)
                .build();
        memberRepository.save(member);
    }

    @Test
    @DisplayName("도서 등록")
    void addBook() {
        // given
        BookInfo bookInfo = BookInfo.builder()
                .title("테스트 도서")
                .link("https://link")
                .image("https://image")
                .author("아무개")
                .price("15000")
                .discount("0")
                .publisher("테스트출판")
                .pubdate("20211202")
                .isbn("9123456789012 3456789012")
                .description("테스트 도서 입니다!")
                .build();

        String email = "user@gmail.com";

        BookRegisterRequest request = new BookRegisterRequest();
        request.setEmail(email);
        request.setBookInfo(bookInfo);

        // when
        String addedBook = bookService.addBook(request);

        // then
        assertThat(addedBook).isEqualTo(request.getBookInfo().getIsbn());
    }
}
