package com.example.bcheckapi.dto;

import com.example.bcheckapi.model.SearchedBook;
import lombok.Getter;

import java.util.List;

@Getter
public class BookSearchResponse extends GeneralResponse {
    private List<SearchedBook> books;

    public BookSearchResponse(int status, String message, List<SearchedBook> books) {
        super(status, message);
        this.books = books;
    }
}
