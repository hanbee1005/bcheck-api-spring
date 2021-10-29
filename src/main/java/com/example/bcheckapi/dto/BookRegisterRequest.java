package com.example.bcheckapi.dto;

import com.example.bcheckapi.model.BookInfo;
import lombok.Getter;

@Getter
public class BookRegisterRequest {
    private String email;
    private String name;

    private BookInfo bookInfo;
}
