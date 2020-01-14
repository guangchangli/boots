package com.aladdin.common.resp;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * json统一返回格式
 *
 * @author lgc
 * @create 2020-01-10 10:34 上午
 **/
@Data
@Builder
public class Result<T> {
    private int code;
    private String errMsg;
    private boolean success;
    private T data;

    public static Result failure(int code, String errMsg, Object data) {
        return Result.builder().code(code).errMsg(errMsg).success(false).data(data).build();
    }
}
