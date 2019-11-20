package com.example.lianfang.service;

import com.example.lianfang.entity.Teacher;

import java.util.List;

public interface TeacherService {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);   // 教师信息插入

    int insertSelective(Teacher record);   //

    Teacher selectByPrimaryKey(String teacherId);  // 查询教师信息

    int updateByPrimaryKeySelective(Teacher record);  // 教师信息修改

    int updateByPrimaryKey(Teacher record);
    List<Teacher> getTeachersByDpId(Integer dpId);
}
