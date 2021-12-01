package com.example.bcheckapi.domain;

import com.example.bcheckapi.model.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Entity
public class MemberEntity {

    @Id
    private String email;

    private String name;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public MemberEntity() {

    }

    // TODO: 비밀번호 암호화
}
