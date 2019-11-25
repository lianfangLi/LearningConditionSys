package com.example.lianfang.mapper;

import com.example.lianfang.entity.StuClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuClassMapper {
    int deleteByPrimaryKey(String classNo);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    StuClass selectByPrimaryKey(String classNo);

    int updateByPrimaryKeySelective(StuClass record);

    int updateByPrimaryKey(StuClass record);
}