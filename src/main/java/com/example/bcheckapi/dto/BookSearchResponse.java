package com.example.bcheckapi.dto;

import com.example.bcheckapi.domain.BookEntity;
import com.example.bcheckapi.model.OwnerInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookSearchResponse {
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

    private List<OwnerInfo> owners;

    public BookSearchResponse(BookEntity book) {
        this.title = book.getTitle();
        this.link = book.getLink();
        this.image = book.getImage();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.discount = book.getDiscount();
        this.publisher = book.getPublisher();
        this.pubdate = book.getPubdate();
        this.isbn = book.getIsbn();
        this.description = book.getDescription();

        this.owners = new ArrayList<>();
        addOwner(book);
    }

    public void addOwner(BookEntity book) {
        OwnerInfo owner = new OwnerInfo(book);
        owners.add(owner);
    }

    @Override
    public String toString() {
        return "BookSearchResponse{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", owners=" + owners +
                '}';
    }
}
