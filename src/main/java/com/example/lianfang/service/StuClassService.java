package com.example.lianfang.service;

import com.example.lianfang.entity.StuClass;

public interface StuClassService {
    int deleteByPrimaryKey(String classNo);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    StuClass selectByPrimaryKey(String classNo);

    int updateByPrimaryKeySelective(StuClass record);

    int updateByPrimaryKey(StuClass record);

}
