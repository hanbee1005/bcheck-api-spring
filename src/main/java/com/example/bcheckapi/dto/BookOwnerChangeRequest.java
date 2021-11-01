package com.example.bcheckapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookOwnerChangeRequest {
    private Long id;

    private String ownerEmail;

    private String ownerName;
}
