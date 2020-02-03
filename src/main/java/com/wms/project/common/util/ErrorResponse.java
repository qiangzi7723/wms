package com.wms.project.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 接口错误处理
@ControllerAdvice
public class ErrorResponse {
    @ExceptionHandler(value =Exception.class)
    public ResponseEntity<Result> handleException(CustomException e){
         Result res = new Result(e.getCode(),e.getMsg());
         return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
