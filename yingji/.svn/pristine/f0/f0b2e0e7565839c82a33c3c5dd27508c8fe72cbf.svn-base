package com.fh.enums;

public enum AuthExceptionEnum {

    USER_ERROR(401,"用户名密码错误"),
    APP_ERROR(500,"应用ID错误"),
    TIMESTAMP_EMPTY(500,"时间戳为空"),
    SIGN_EMPTY(500,"content-Signature为空"),
    SIGN_ERROR(500,"content-Signature错误"),
    ;


    private int code;

    private String desc;

    AuthExceptionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
