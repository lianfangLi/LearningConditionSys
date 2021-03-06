package com.example.lianfang.service;

import com.example.lianfang.entity.Student;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByClassNo(String classNo);
}
