package com.example.bcheckapi.domain;

import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.model.BookInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "book_detail")
public class BookDetailEntity {

    @Id
    private String isbn;

    private String title;

    private String link;

    private String image;

    private String author;

    private String price;

    private String discount;

    private String publisher;

    private String pubdate;

    private String description;

    @OneToMany(mappedBy = "isbn")
    private List<BookEntity> books = new ArrayList<>();

    @Builder
    public BookDetailEntity(BookRegisterRequest req) {
        BookInfo bookInfo = req.getBookInfo();
        title = bookInfo.getTitle();
        link = bookInfo.getLink();
        image = bookInfo.getImage();
        author = bookInfo.getAuthor();
        price = bookInfo.getPrice();
        discount = bookInfo.getDiscount();
        publisher = bookInfo.getPublisher();
        pubdate = bookInfo.getPubdate();
        isbn = bookInfo.getIsbn();
        description = bookInfo.getDescription();
    }
}
