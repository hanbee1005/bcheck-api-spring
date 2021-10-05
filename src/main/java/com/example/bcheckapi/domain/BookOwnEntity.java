package com.example.bcheckapi.domain;

import com.example.bcheckapi.dto.BookOwnerRegisterRequest;
import com.example.bcheckapi.model.BookInfo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookown")
public class BookOwnEntity {

    @Id
    @GeneratedValue
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

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "owner_nm")
    private String ownerNm;

    @Column(name = "own_date")
    private Date ownDate;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "del_cd")
    private String delCd;

    @Column(name = "del_msg")
    private String delMsg;

    @Column(name = "update_date")
    private Date updateDate;

    @Builder
    public BookOwnEntity(BookOwnerRegisterRequest req) {
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

        ownerId = req.getEmail();
        ownerNm = req.getName();
        ownDate = new Date();
        delYn = "N";
    }
}
