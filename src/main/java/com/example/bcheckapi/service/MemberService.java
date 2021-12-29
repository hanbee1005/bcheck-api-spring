package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.MemberEntity;
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
     * 회원 조회 (이름으로 검색)
     * @param name
     * @return
     */
    public MemberSearchResponse searchByName(String name) {
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

    /**
     * 회원 조회 (email 검색)
     * @param email
     * @return
     */
    public MemberEntity searchById(String email) {
        return memberRepository.findById(email).orElseThrow();
    }
}
