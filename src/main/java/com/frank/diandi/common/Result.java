package com.frank.diandi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/18
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private String code;

    private String message;

    private T data;


    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(String message, T data) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> failed() {
        return new Result<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }


}
