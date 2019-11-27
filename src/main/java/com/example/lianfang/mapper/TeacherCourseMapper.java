package com.example.lianfang.mapper;

import com.example.lianfang.entity.TeacherCourse;
import com.example.lianfang.entity.TeacherCourseKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherCourseMapper {
    int deleteByPrimaryKey(TeacherCourseKey key);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    TeacherCourse selectByPrimaryKey(TeacherCourseKey key);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);
}