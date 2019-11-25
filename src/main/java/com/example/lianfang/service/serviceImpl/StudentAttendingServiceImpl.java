package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.Student;
import com.example.lianfang.mapper.StudentAttendingMapper;
import com.example.lianfang.service.StudentAttendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentAttendingServiceImpl implements StudentAttendingService {


    @Autowired
    StudentAttendingMapper studentAttendingMapper;

    @Override
    public int insertByClassNo(List<Student> stuList, String year, String term, String sub, Integer time, String isattend,String class_no) {
        return studentAttendingMapper.insertByClassNo(stuList,year,term,sub,time,isattend,class_no);
    }
    @Override
    public List<Attending> selectIsAttendingExist(Attending attending) {
        return studentAttendingMapper.selectIsAttendingExist(attending);
    }
}
