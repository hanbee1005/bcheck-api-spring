package com.example.bcheckapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRemoveRequest {
    private Long id;
    private String delCd;
    private String delNm;
    private String delMsg;
}
