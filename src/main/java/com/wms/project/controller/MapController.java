package com.wms.project.controller;

import com.wms.project.common.util.Result;
import com.wms.project.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("map")
public class MapController {
    @Autowired
    private  MapService mapService;

    @GetMapping("mark")
    public ResponseEntity<Result> mark(){
        mapService.mapMark();
        Result res = new Result();
        return ResponseEntity.ok(res);
    }
}
