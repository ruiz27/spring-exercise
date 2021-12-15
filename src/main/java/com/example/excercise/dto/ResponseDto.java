package com.example.excercise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String message;
    private String code;

    public ResponseDto(String message, String code){
        this.message = message;
        this.code = code;
    }
}
