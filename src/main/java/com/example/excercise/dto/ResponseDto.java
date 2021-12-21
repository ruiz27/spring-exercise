package com.example.excercise.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto {
    private String message;
    private String code;

    public ResponseDto(String message, String code){
        this.message = message;
        this.code = code;
    }
}
