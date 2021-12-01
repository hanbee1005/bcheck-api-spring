package com.example.bcheckapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원 정보")
public class MemberInfo {

    @Schema(description = "이메일", example = "user@gmail.com")
    private String email;

    @Schema(description = "이름", example = "홍길동")
    private String name;
}
