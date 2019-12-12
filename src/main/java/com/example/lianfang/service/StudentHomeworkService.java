package com.example.lianfang.service;

import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.Student;

import java.util.List;

public interface StudentHomeworkService {
    int insertByClassNo(List<Student> stuList, String year, String term, String sub, Integer time, String isattend, String class_no);
    List<Homework> selectIsHomeworkExist(Homework attending );
}
