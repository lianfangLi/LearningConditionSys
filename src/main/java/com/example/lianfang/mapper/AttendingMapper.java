package com.example.lianfang.mapper;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.AttendingKey;

public interface AttendingMapper {
    int deleteByPrimaryKey(AttendingKey key);

    int insert(Attending record);

    int insertSelective(Attending record);

    Attending selectByPrimaryKey(AttendingKey key);

    int updateByPrimaryKeySelective(Attending record);

    int updateByPrimaryKey(Attending record);



}