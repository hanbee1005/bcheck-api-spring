package com.example.bcheckapi.dto;

import com.example.bcheckapi.model.BookInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "도서 등록 요청 객체")
public class BookRegisterRequest {
    @Schema(description = "소유자 이메일", example = "test1@gmail.com")
    private String email;
    @Schema(description = "소유자명", example = "테스터1")
    private String name;

    @Schema(description = "등록할 도서 정보")
    private BookInfo bookInfo;
}
