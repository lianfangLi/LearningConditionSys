package com.example.lianfang.mapper;

import com.example.lianfang.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     *  查询 某一班级的所有 学生 的学号 姓名
     *
     * @param classNo
     * @return
     */
    List<Student> selectByClassNo(String classNo);
}