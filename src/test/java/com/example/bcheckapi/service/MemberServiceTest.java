package com.example.bcheckapi.service;

import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.dto.MemberSearchResponse;
import com.example.bcheckapi.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @BeforeEach
    void init() {
        MemberRegisterRequest request1 = new MemberRegisterRequest();
        request1.setEmail("user1@gmail.com");
        request1.setName("홍길동");
        request1.setPassword("1234");

        saveMember(request1);

        MemberRegisterRequest request2 = new MemberRegisterRequest();
        request2.setEmail("user2@gmail.com");
        request2.setName("김영희");
        request2.setPassword("1234");

        saveMember(request2);

        MemberRegisterRequest request3 = new MemberRegisterRequest();
        request3.setEmail("user3@gmail.com");
        request3.setName("김철수");
        request3.setPassword("1234");

        saveMember(request3);
    }

    private void saveMember(MemberRegisterRequest request) {
        MemberEntity member = MemberEntity.builder().request(request).build();
        memberRepository.save(member);
    }

    @Test
    @DisplayName("회원 조회")
    void searchMember() {
        // given
        String name = "김";

        // when
        MemberSearchResponse searchedMember = memberService.searchByName(name);

        // then
        assertThat(searchedMember.getStatus()).isEqualTo(200);
        assertThat(searchedMember.getData().size()).isEqualTo(2);
    }

}