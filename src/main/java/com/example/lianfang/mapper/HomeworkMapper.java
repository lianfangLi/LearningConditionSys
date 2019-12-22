package com.example.lianfang.mapper;

import com.example.lianfang.entity.*;
import com.example.lianfang.entity.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface HomeworkMapper {
    int deleteByPrimaryKey(HomeworkKey key);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(HomeworkKey key);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);

    int updateHomeworkSituation(@Param("list") List<Homework> list);

    List<Homework> checkByClass(Homework msg);

    int deleteByClass(Homework msg);

    List<Homework> selectByClassAndTimes(Homework msg);

    List<Homework> selectBystuYearAndTerm(Homework msg);

    List<HomeworkExtends> selectBystuYearAndTermToGetTimes(Homework msg);

    List<HomeworkExtends> selectByStuIdAndYearAndTermAndSubjectToGetTimes(Homework msg);
}