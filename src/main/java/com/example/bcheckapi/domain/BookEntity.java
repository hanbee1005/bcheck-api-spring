package com.example.bcheckapi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;

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
    public BookEntity(MemberEntity member, BookDetailEntity bookDetail) {
        setMember(member);
        setBookDetail(bookDetail);
        ownDt = new Date();
    }

    // == 연관관계 메소드 == //
    public void setMember(MemberEntity member) {
        this.member = member;
        member.getBooks().add(this);
    }

    public void setBookDetail(BookDetailEntity bookDetail) {
        this.bookDetail = bookDetail;
        bookDetail.getBooks().add(this);
    }
}
