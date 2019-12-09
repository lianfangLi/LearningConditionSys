package com.example.lianfang.service;

import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.FinalGradeKey;
import com.example.lianfang.mapper.FinalGradeMapper;

import java.util.List;

public interface FinalGradeService {

    int deleteByPrimaryKey(FinalGradeKey key);

    int insert(FinalGrade record);

    int insertSelective(FinalGrade record);

    FinalGrade selectByPrimaryKey(FinalGradeKey key);

    int updateByPrimaryKeySelective(FinalGrade record);

    int updateByPrimaryKey(FinalGrade record);

    List<FinalGrade> checkIsClassRecordExists(FinalGrade record);

    int deleteRecordByClassAndCour(FinalGrade record);

    List<FinalGrade> inquireStudentsGradesByClassOrCourNo(FinalGrade record);

    List<FinalGrade> singleStudentGradeInquire(FinalGrade record);
}
