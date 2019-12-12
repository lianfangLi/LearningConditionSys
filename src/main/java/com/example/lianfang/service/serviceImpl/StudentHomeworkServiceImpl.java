package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.Student;
import com.example.lianfang.mapper.StudentHomeworkMapper;
import com.example.lianfang.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentHomeworkServiceImpl implements StudentHomeworkService {
    @Autowired
    StudentHomeworkMapper studentHomeworkMapper;
    @Override
    public int insertByClassNo(List<Student> stuList, String year, String term, String sub, Integer time, String isattend, String class_no) {
        return studentHomeworkMapper.insertByClassNo(stuList,year,term,sub,time,isattend,class_no);
    }

    @Override
    public List<Homework> selectIsHomeworkExist(Homework attending) {
        return studentHomeworkMapper.selectIsHomeworkExist(attending);
    }
}
