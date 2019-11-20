package com.example.lianfang.mapper;

import com.example.lianfang.entity.StudentCommonGrade;
import com.example.lianfang.entity.StudentCommonGradeKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCommonGradeMapper {
    int deleteByPrimaryKey(StudentCommonGradeKey key);

    int insert(StudentCommonGrade record);

    int insertSelective(StudentCommonGrade record);

    StudentCommonGrade selectByPrimaryKey(StudentCommonGradeKey key);

    int updateByPrimaryKeySelective(StudentCommonGrade record);

    int updateByPrimaryKey(StudentCommonGrade record);
}