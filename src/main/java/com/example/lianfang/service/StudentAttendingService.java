package com.example.lianfang.service;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAttendingService {

    int insertByClassNo(List<Student> stuList,  String year,  String term,  String sub,  Integer time, String isattend,String class_no);
    List<Attending> selectIsAttendingExist(Attending attending );

    public void finalGradeModify(List<Attending> record);


}
