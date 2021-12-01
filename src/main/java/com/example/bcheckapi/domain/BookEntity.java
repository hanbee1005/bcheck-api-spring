package com.example.bcheckapi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn")
    private BookDetailEntity bookDetail;

    @Column(name = "own_dt")
    private Date ownDt;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "del_cd")
    private String delCd;

    @Builder
    public BookEntity() {

    }
}
