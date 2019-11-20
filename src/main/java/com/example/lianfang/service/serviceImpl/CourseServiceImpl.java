package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Course;
import com.example.lianfang.mapper.CourseMapper;
import com.example.lianfang.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(String courNo) {
        return courseMapper.deleteByPrimaryKey(courNo);
    }

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(String courNo) {
        return courseMapper.selectByPrimaryKey(courNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }
}
