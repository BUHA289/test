package com.example.testjdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public class MemoResponseDto {

    private final Long id;
    private final String content;

    public MemoResponseDto(Long id, String content) {
        this.id = id;

        this.content = content;
    }
}
