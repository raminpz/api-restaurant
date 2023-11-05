package com.softrami.apirestaurant.dto;

public class ErrorDto {
    private static final long serialVersionUID=1L;
    private String name;
    private String value;

    public ErrorDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
