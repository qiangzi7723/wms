package com.wms.project.common.util;


import lombok.*;

@Data
public class CustomException extends RuntimeException{

    private Integer code;
    private String msg;

    public CustomException(){
        super();
        this.code = -1;
        this.msg = "初始化异常信息";
    }

    public CustomException(Integer code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }
}
