package com.example.bcheckapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "도서 소유자 정보")
@Builder
public class OwnerInfo {

    @Schema(description = "도서ID", example = "1")
    private Long bookId;

    @Schema(description = "이메일", example = "user@gmail.com")
    private String email;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "보유날짜", example = "")
    private Date ownDate;

    @Schema(description = "삭제유무", example = "N")
    private String delYn;
}
