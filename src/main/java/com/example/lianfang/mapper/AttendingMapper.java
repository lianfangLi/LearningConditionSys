package com.example.lianfang.mapper;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.AttendingKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AttendingMapper {
    int deleteByPrimaryKey(AttendingKey key);

    int insert(Attending record);

    int insertSelective(Attending record);

    Attending selectByPrimaryKey(AttendingKey key);

    int updateByPrimaryKeySelective(Attending record);

    int updateByPrimaryKey(Attending record);

    int updateAttendingSituation(@Param("list")List<Attending> list);

    List<Attending> checkByClass(Attending msg);

    int deleteByClass(Attending msg);
    List<Attending> selectByStuNo(Attending msg);



}