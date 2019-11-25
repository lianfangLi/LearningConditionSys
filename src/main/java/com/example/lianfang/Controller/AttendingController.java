package com.example.lianfang.Controller;


import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.Attending;

import com.example.lianfang.entity.Student;
import com.example.lianfang.entity.StudentAttending;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.StuClassService;
import com.example.lianfang.service.StudentAttendingService;
import com.example.lianfang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "学生考勤与作业相关接口")
@RestController("/attend")
@ResponseBody
@CrossOrigin
public class AttendingController {
    @Autowired                          // 考勤表 dao
    StudentAttendingService studentAttendingService;
    @Autowired                       // 学生表 dao
    StudentService studentService;
    @Autowired               //  班级表 dao
    StuClassService stuClassService;

    @ApiOperation(value = "创建某班考勤情况",notes = " 异常状态：无此班级，有班级该班级无学生，该次考勤已经添加过。 失败时后多返回一个fail字段表明失败原因 自己测试")
    @PostMapping("/createByClass")
    public String createByClass(@RequestBody @ApiParam(name="attending",value = "model里面班级号，学年，学期，科目，次数，必填，其他参数无视 ") Attending attending){

        Map map = SqlUtils.getMap();               // 该班级 不存在
        if(stuClassService.selectByPrimaryKey(attending.getClassNo()) == null ){
            map.put("status","FAILURE");
            map.put("reason"," no such class!");
            return JSON.toJSONString(map);
        }
        List<Student> students = studentService.selectByClassNo(attending.getClassNo()); // 获取该班级的学生相关信息
        if( students == null || students.size() == 0){      // 判断该班级 是否有学生存在

            map.put("status","FAILURE");
            map.put("reason"," no students in class!");
           return JSON.toJSONString(map);
        }
       /* *//**
         *  查询 此时 该班级 是否 有此考勤纪律
         *//*
        List<Attending> temp = studentAttendingService.selectIsAttendingExist(attending) ;
        if(temp == null || temp.size() != 0){
            map.put("status","FAILURE");
            map.put("reason","attending record exist!");
            return JSON.toJSONString(map);

        }*/
        /**
         *  查询得知此时有该班级以及有该班级的学生 并且 无此条考勤纪律 插入
         */
        try{
            if(studentAttendingService.insertByClassNo(students,attending.getWhichYear(),attending.getWhichTerm(),
                    attending.getWhichSubject(),attending.getWhichTime(),"1",attending.getClassNo()) != 0){
                return SqlUtils.success;
            }
        }
        catch(Exception e){
            map.put("status","FAILURE");
            map.put("reason"," attending record exists!");

        }
        return JSON.toJSONString(map);
    }
}
