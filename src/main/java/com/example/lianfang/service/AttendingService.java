package com.example.lianfang.service;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.AttendingKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendingService {
    int deleteByPrimaryKey(AttendingKey key);

    int insert(Attending record);

    int insertSelective(Attending record);

    Attending selectByPrimaryKey(AttendingKey key);

    int updateByPrimaryKeySelective(Attending record);

    int updateByPrimaryKey(Attending record);

    int updateAttendingSituation(@Param("list") List<Attending> list);

    List<Attending> checkByClass(Attending msg);

    int deleteByClass(Attending msg);
}
