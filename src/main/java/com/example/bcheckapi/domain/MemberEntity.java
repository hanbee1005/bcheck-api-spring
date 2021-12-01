package com.example.bcheckapi.domain;

import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "member")
    private List<BookEntity> books = new ArrayList<>();

    @Builder
    public MemberEntity(MemberRegisterRequest request) {
        email = request.getEmail();
        name = request.getName();
        password = request.getPassword();

        role = Role.U;
    }

    // TODO: 비밀번호 암호화
}
