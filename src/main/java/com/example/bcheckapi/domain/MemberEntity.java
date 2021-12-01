package com.example.bcheckapi.domain;

import com.example.bcheckapi.model.Role;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "member")
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
