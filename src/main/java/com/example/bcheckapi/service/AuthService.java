package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.MemberLoginRequest;
import com.example.bcheckapi.dto.MemberLoginResponse;
import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.dto.MemberSearchResponse;
import com.example.bcheckapi.repository.MemberRepository;
import com.example.bcheckapi.security.JwtTokenProvider;
import com.example.bcheckapi.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 회원 가입
     * @param request
     * @return
     */
    public String register(MemberRegisterRequest request) {
        MemberEntity memberEntity = MemberEntity.builder()
                .request(request)
                .passwordEncoder(passwordEncoder)
                .build();
        memberRepository.save(memberEntity);

        return request.getEmail();
    }

    /**
     * 로그인
     * @param request
     * @return
     */
    public MemberLoginResponse login(MemberLoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        return createJwtToken(authentication);
    }

    private MemberLoginResponse createJwtToken(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);
        return new MemberLoginResponse(token);
    }
}
