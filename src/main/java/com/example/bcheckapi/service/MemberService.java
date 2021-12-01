package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.dto.MemberSearchResponse;
import com.example.bcheckapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param request
     * @return
     */
    public String register(MemberRegisterRequest request) {
        // TODO: 비밀번호 암호화 설정
        MemberEntity memberEntity = MemberEntity.builder().request(request).build();
        memberRepository.save(memberEntity);

        return request.getEmail();
    }

    // 회원 조회 (이름으로 검색)
    public MemberSearchResponse search(String name) {
        List<MemberEntity> members = memberRepository.findByNameContains(name);

        MemberSearchResponse response = new MemberSearchResponse();

        if (!members.isEmpty()) {
            response.setStatus(200);
            response.setMessage("회원 조회 성공");
            response.setData(members);
        } else {
            response.setStatus(404);
            response.setMessage("회원이 존재하지 않습니다.");
        }

        return response;
    }
}
