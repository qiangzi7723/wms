package com.wms.project.dao;

import com.wms.project.modal.Mark;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MapDao {
    Mark insertMark();
}
