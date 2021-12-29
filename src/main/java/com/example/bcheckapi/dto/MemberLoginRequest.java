package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "로그인 요청 정보")
public class MemberLoginRequest {
    @Schema(description = "이메일", example = "user@gmail.com")
    private String email;

    @Schema(description = "비밀번호", example = "1234")
    private String password;
}
