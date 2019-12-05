package com.example.lianfang.service;

import com.example.lianfang.entity.TeacherCourse;
import com.example.lianfang.entity.TeacherCourseExtends;
import com.example.lianfang.entity.TeacherCourseKey;

import java.util.List;

public interface TeacherCourseService {
    int deleteByPrimaryKey(TeacherCourseKey key);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    TeacherCourse selectByPrimaryKey(TeacherCourseKey key);

    int updateByPrimaryKeySelective(TeacherCourse record);

    int updateByPrimaryKey(TeacherCourse record);

    List<TeacherCourse> inquireClassAndCourByTeaIdAndYearAndTerm(TeacherCourse teacherCourse);

    List<TeacherCourseExtends> inqueireCourByclass(TeacherCourse teacherCourse);
}
