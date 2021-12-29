package com.example.bcheckapi.dto;

import com.example.bcheckapi.domain.BookDetailEntity;
import com.example.bcheckapi.model.BookInfo;
import com.example.bcheckapi.model.OwnerInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "도서 검색 응답 정보")
public class BookSearchResponse {

    @Schema(description = "도서 정보")
    private BookInfo bookInfo;

    @Schema(description = "소유자 정보")
    private List<OwnerInfo> owners;

    public BookSearchResponse(BookDetailEntity entity) {

    }
}
