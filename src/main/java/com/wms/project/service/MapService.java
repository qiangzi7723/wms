package com.wms.project.service;

import com.wms.project.dao.MapDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    @Autowired
    private MapDao mapDao;

    public void mapMark(){
//        判断是否可以签到打卡
        mapDao.insertMark();
    }
}
