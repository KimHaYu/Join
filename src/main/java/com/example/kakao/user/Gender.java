package com.example.kakao.user;

public enum Gender {
    MAN("MAN"), WOMAN("WOMAN");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
