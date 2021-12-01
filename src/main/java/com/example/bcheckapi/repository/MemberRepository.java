package com.example.bcheckapi.repository;

import com.example.bcheckapi.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    List<MemberEntity> findByName(String name);
}
