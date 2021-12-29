package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "기본 응답 객체")
public class GeneralResponse {
    @Schema(description = "응답 상태", example = "200")
    private int status;

    @Schema(description = "응답 메시지", example = "성공")
    private String message;

    @Schema(description = "데이터", example = "")
    private String data;
}
