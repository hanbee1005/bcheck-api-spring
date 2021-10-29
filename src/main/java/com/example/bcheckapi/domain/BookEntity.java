package com.example.bcheckapi.domain;

import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.model.BookInfo;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String image;

    private String author;

    private String price;

    private String discount;

    private String publisher;

    private String pubdate;

    private String isbn;

    private String description;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "del_cd")
    private String delCd;

    @Column(name = "del_nm")
    private String delNm;

    @Column(name = "del_msg")
    private String delMsg;

    @Column(name = "\"createdAt\"")
    @CreatedDate
    private Date createdAt;

    @Column(name = "\"updatedAt\"")
    @LastModifiedDate
    private Date updatedAt;

    @Builder
    public BookEntity(BookRegisterRequest req) {
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

        ownerEmail = req.getEmail();
        ownerName = req.getName();
        delYn = "N";
        createdAt = new Date();
        updatedAt = new Date();
    }
}
