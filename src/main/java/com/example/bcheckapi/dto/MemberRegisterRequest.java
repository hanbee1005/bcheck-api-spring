package com.example.bcheckapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "회원가입 요청 정보")
public class MemberRegisterRequest {
    @Schema(description = "이메일", example = "user@gmail.com")
    private String email;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "비밀번호", example = "1234")
    private String password;
}
