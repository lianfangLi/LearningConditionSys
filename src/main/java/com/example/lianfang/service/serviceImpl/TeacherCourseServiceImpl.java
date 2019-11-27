package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.TeacherCourse;
import com.example.lianfang.entity.TeacherCourseKey;
import com.example.lianfang.mapper.TeacherCourseMapper;
import com.example.lianfang.service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Autowired
    TeacherCourseMapper teacherCourseMapper;

    @Override
    public int deleteByPrimaryKey(TeacherCourseKey key) {
        return teacherCourseMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(TeacherCourse record) {
        return teacherCourseMapper.insert(record);
    }

    @Override
    public int insertSelective(TeacherCourse record) {
        return teacherCourseMapper.insertSelective(record);
    }

    @Override
    public TeacherCourse selectByPrimaryKey(TeacherCourseKey key) {
        return teacherCourseMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(TeacherCourse record) {
        return teacherCourseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TeacherCourse record) {
        return teacherCourseMapper.updateByPrimaryKey(record);
    }
}
