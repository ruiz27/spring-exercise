package com.example.excercise.dto;

import lombok.Getter;
import lombok.Setter;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-10T09:50:17.222Z")

@javax.xml.bind.annotation.XmlRootElement
@Setter
@Getter
public class ResponseDto {
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;
    public static final int OK = 4;
    public static final int TOO_BUSY = 5;

    int code;
    String message;

    public ResponseDto(){}

    public ResponseDto(int code, String message){
        this.code = code;
        this.message = message;
    }

}
