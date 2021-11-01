package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "도서 삭제 요청 객체")
public class BookRemoveRequest {
    @Schema(description = "도서 id", example = "1")
    private Long id;

    @Schema(description = "삭제 코드", example = "D01")
    private String delCd;

    @Schema(description = "삭제 코드명", example = "분실")
    private String delNm;

    @Schema(description = "삭제 메시지", example = "갑자기 사라졌어요...ㅠ")
    private String delMsg;
}
