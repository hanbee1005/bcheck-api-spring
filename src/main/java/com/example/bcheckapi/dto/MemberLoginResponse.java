package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

@Schema(description = "로그인 응답 정보")
public class MemberLoginResponse {

    @Schema(description = "액세스토큰", example = "dhsklhelhfiahifhlsahkdlfhkds")
    private final String accessToken;
}
