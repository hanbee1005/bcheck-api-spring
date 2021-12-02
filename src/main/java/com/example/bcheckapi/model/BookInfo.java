package com.example.bcheckapi.model;

import com.example.bcheckapi.domain.BookDetailEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "도서 정보")
public class BookInfo {
    @Schema(description = "제목", example = "토비의 스프링 3.1 세트 (스프링의 이해와 원리 + 스프링의 기술과 선택, 전2권)")
    private String title;

    @Schema(description = "링크", example = "http://book.naver.com/bookdb/book_detail.php?bid=7006516")
    private String link;

    @Schema(description = "이미지", example = "https://bookthumb-phinf.pstatic.net/cover/070/065/07006516.jpg?type=m1&udate=20151005")
    private String image;

    @Schema(description = "작가", example = "이일민")
    private String author;

    @Schema(description = "가격", example = "75000")
    private String price;

    @Schema(description = "할인가격", example = "67500")
    private String discount;

    @Schema(description = "출판사", example = "에이콘출판")
    private String publisher;

    @Schema(description = "출간일", example = "20120921")
    private String pubdate;

    @Schema(description = "isbn", example = "8960773433 9788960773431")
    private String isbn;

    @Schema(description = "설명", example = "『토비의 스프링 3.1』은 스프링을 처음 접하거나 스프링을 경험했지만 스프링이 어렵게 느껴지는 개발자부터 스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블이다.[Vol. 1 스프링의 이해와 원리] 단순한 예제를... ")
    private String description;

    @Builder
    public BookInfo(BookDetailEntity entity) {
        title = entity.getTitle();
        link = entity.getLink();
        image = entity.getImage();
        author = entity.getAuthor();
        price = entity.getPrice();
        discount = entity.getDiscount();
        publisher = entity.getPublisher();
        pubdate = entity.getPubdate();
        isbn = entity.getIsbn();
        description = entity.getDescription();
    }
}
