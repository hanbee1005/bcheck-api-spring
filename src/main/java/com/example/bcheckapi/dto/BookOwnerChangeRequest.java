package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "도서 소유자 수정 요청 객체")
public class BookOwnerChangeRequest {
    @Schema(description = "도서 id", example = "1")
    private Long id;

    @Schema(description = "변경할 소유자 이메일", example = "test3@gmail.com")
    private String ownerEmail;

    @Schema(description = "변경할 소유자명", example = "테스터3")
    private String ownerName;
}
