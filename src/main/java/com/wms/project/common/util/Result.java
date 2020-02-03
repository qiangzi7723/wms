package com.wms.project.common.util;


import lombok.Data;
import java.util.HashMap;
import java.util.Map;

// 接口返回格式处理
@Data
public class Result {
    private String message;
    private Integer code;
    private Map<String,Object> data = new HashMap<String, Object>();


    public Result(){
        this.message = "OK";
        this.code = 0;
    }

    public Result(String message,Integer code){
        this.message = message;
        this.code = code;
    }

    public void putData(String key,Object value){
        data.put(key,value);
    }

    public Map<String,Object> getData(){
        return data;
    }

}
