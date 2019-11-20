package com.example.lianfang.mapper;

import com.example.lianfang.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);   // 教师信息插入

    int insertSelective(Teacher record);   //

    Teacher selectByPrimaryKey(String teacherId);  // 查询教师信息

    int updateByPrimaryKeySelective(Teacher record);  // 教师信息修改

    int updateByPrimaryKey(Teacher record);
    List<Teacher> getTeachersByDpId(Integer dpId);
}