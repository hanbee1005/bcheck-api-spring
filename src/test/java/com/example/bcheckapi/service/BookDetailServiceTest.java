package com.example.bcheckapi.service;

import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.repository.BookDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BookDetailServiceTest {

    @Autowired BookDetailService bookDetailService;
    @Autowired BookDetailRepository bookDetailRepository;

    List<BookInfo> bookInfoList = new ArrayList<>();

    @BeforeEach
    void init() {
        String[] book1 = {
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

        bookInfoList.add(makeBookInfo(book1));
        bookInfoList.add(makeBookInfo(book2));
        bookInfoList.add(makeBookInfo(book3));
    }

    private BookInfo makeBookInfo(String[] book) {

        return BookInfo.builder()
                .title(book[0])
                .link(book[1])
                .image(book[2])
                .author(book[3])
                .price(book[4])
                .discount(book[5])
                .publisher(book[6])
                .pubdate(book[7])
                .isbn(book[8])
                .description(book[9])
                .build();
    }
}