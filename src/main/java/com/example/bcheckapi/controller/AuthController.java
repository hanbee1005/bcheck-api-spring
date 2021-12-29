package com.example.bcheckapi.controller;

import com.example.bcheckapi.dto.GeneralResponse;
import com.example.bcheckapi.dto.MemberLoginRequest;
import com.example.bcheckapi.dto.MemberLoginResponse;
import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "[001] 회원 관리", description = "회원 가입, 로그인")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(description = "로그인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공",
                    content = @Content(schema = @Schema(implementation = MemberLoginResponse.class)))
    })
    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(description = "회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공",
                    content = @Content(schema = @Schema(implementation = GeneralResponse.class)))
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody MemberRegisterRequest request) {
        boolean success = authService.register(request);
        if (success) {
            return ResponseEntity.ok(new GeneralResponse(200, "회원가입에 성공하였습니다.", request.getEmail()));
        } else {
            return new ResponseEntity<>(
                    new GeneralResponse(400, "이미 가입된 회원입니다.", request.getEmail()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
