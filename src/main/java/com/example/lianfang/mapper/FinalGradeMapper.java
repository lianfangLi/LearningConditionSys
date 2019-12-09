package com.example.lianfang.mapper;

import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.FinalGradeKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinalGradeMapper {
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