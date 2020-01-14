package com.aladdin.common.exception;

import com.aladdin.common.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 * 全局异常处理
 *
 * @author lgc
 * @create 2020-01-10 2:54 下午
 **/
@Slf4j
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        logger.error(ex.getMessage(), ex);//打印异常信息
        Result respMsg = Result.failure(status.value(), ex.getMessage(), null);//使用http状态码作为返回体的code,同时把异常信息返回
        return new ResponseEntity<>(respMsg, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuffer sb = new StringBuffer();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            sb.append(error.getDefaultMessage()).append(";");
        });
        Result respMsg = Result.failure(status.value(), sb.toString(), null);
        return new ResponseEntity<>(respMsg, headers, HttpStatus.OK);//这里可以根据具体情况改变状态码
    }
}
