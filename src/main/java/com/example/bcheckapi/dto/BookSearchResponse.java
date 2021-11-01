package com.example.bcheckapi.dto;

import com.example.bcheckapi.model.SearchedBook;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
@Schema(description = "도서 조회 응답 객체")
public class BookSearchResponse extends GeneralResponse {
    @Schema(description = "검색된 도서 리스트")
    private List<SearchedBook> books;

    public BookSearchResponse(int status, String message, List<SearchedBook> books) {
        super(status, message);
        this.books = books;
    }
}
