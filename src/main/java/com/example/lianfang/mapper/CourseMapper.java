package com.example.lianfang.mapper;

import com.example.lianfang.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(String courNo);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String courNo);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}