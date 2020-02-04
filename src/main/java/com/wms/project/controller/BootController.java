package com.wms.project.controller;

import com.wms.project.common.util.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class BootController {
    @GetMapping("status")
    public ResponseEntity<Result> status(){
//        TODO 可以优化->优化思路：写一个中间件，统一把返回的参数写到中间件，由中间件构造返回体
        Result res = new Result();
        return ResponseEntity.ok(res);
    }

//    当前接口需要JWT
    @GetMapping("needJwt")
    public void needJwt(){
        System.out.println("走到了控制器");
    }

    @GetMapping("noJwt")
    public Result noJwt(){
        Result res = new Result();
        return res;
    }
}
