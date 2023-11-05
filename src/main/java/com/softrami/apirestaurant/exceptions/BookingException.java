package com.softrami.apirestaurant.exceptions;

import com.softrami.apirestaurant.dto.ErrorDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookingException extends Exception{

    private static final long serialVersionUID = 1L;
    private final String code;
    private final int respondeCode;

    private final List<ErrorDto> errorList = new ArrayList<>();

    public BookingException(String code, int respondeCode, String message) {
        super(message);
        this.code = code;
        this.respondeCode = respondeCode;
    }

    public BookingException(String code, int respondeCode, String message, List<ErrorDto> errorList) {
        super(message);
        this.code = code;
        this.respondeCode = respondeCode;
        this.errorList.addAll(errorList);
    }
}
