package com.example.lianfang.service;

import com.example.lianfang.entity.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    int deleteByPrimaryKey(String courNo);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String courNo);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
