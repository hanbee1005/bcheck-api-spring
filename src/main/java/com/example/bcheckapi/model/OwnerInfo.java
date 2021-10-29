package com.example.bcheckapi.model;

import com.example.bcheckapi.domain.BookEntity;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class OwnerInfo {
    private Long id;

    private String ownerEmail;

    private String ownerName;

    private String delYn;

    private String delCd;

    private String delNm;

    private String delMsg;

    private String ownDate;

    private String delDate;

    public OwnerInfo(BookEntity book) {
        this.id = book.getId();
        this.ownerEmail = book.getOwnerEmail();
        this.ownerName = book.getOwnerName();
        this.delYn = book.getDelYn();
        this.delCd = book.getDelCd();
        this.delNm = book.getDelNm();
        this.delMsg = book.getDelMsg();
        this.ownDate = dateToString(book.getUpdatedAt());
        this.delDate = "Y".equals(book.getDelYn()) ? dateToString(book.getUpdatedAt()) : null;
    }

    private String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }
}
