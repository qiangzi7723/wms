package com.wms.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
    @GetMapping("status")
    public String status(){
        return "Everying is Ok!";
    }
}
