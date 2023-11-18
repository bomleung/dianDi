package com.frank.diandi.common;

/**
 * @author frank
 * @date 2023/11/18
 **/
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("20000", "success"),

    FAILED("20001", "failed");


    /**
     * 返回值
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
