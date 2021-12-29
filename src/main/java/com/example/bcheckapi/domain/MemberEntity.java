package com.example.bcheckapi.domain;

import com.example.bcheckapi.dto.MemberRegisterRequest;
import com.example.bcheckapi.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public MemberEntity(MemberRegisterRequest request, PasswordEncoder passwordEncoder) {
        email = request.getEmail();
        name = request.getName();
        password = passwordEncoder.encode(request.getPassword());

        role = Role.USER;
    }
}
