package com.example.lianfang.mapper;

import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.HomeworkKey;

public interface HomeworkMapper {
    int deleteByPrimaryKey(HomeworkKey key);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(HomeworkKey key);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);
}