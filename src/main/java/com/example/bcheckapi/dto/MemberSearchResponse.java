package com.example.bcheckapi.dto;

import com.example.bcheckapi.domain.MemberEntity;
import com.example.bcheckapi.model.MemberInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Schema(description = "회원 검색")
public class MemberSearchResponse {

    @Schema(description = "응답 상태", example = "200")
    private int status;

    @Schema(description = "응답 메시지", example = "성공")
    private String message;

    @Schema(description = "응답 데이터", example = "[]")
    private List<MemberInfo> data;

    public void setData(List<MemberEntity> members) {
        data = new ArrayList<>();

        for (MemberEntity member : members) {
            MemberInfo info = new MemberInfo();
            info.setEmail(member.getEmail());
            info.setName(member.getName());

            data.add(info);
        }
    }
}
