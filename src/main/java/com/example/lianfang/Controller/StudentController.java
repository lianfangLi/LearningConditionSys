package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.Student;
import com.example.lianfang.entity.Teacher;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "学生操作相关接口",description= "学生增删查改操作")
@RestController("/student")
@ResponseBody
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation(value = "学生注册接口",notes = "注册时每项属性必填")
    @PostMapping("/studentRegister")
    public String registe(@RequestBody Student student){
        if(studentService.selectByPrimaryKey(student.getId()) != null || studentService.insertSelective(student) == 0 ) return SqlUtils.wrong;
        return SqlUtils.success;
    }
    @ApiOperation(value = "学生修改接口",notes = "修改时除id属性，其他属性选填")
    @PostMapping("/studentModify")
    public String modify(@RequestBody Student student){

        if(/*studentService.selectByPrimaryKey(student.getId()) == null ||*/ studentService.updateByPrimaryKeySelective(student) == 0 ) return SqlUtils.wrong;
        return SqlUtils.success;

    }

    @ApiOperation(value = "学生信息获取接口", notes = "通过学生学号获取")
    @PostMapping("/inquireStuMsg")
    public String inquire(@RequestParam @ApiParam( name = "id") String id ){
        Map map = SqlUtils.getMap();
        Student stu = studentService.selectByPrimaryKey(id);
        if( stu != null){
                map.put("msg", JSON.toJSONString(stu));
                return JSON.toJSONString(map);
        }
        return SqlUtils.wrong;
    }
    @ApiOperation(value = "学生信息注销接口", notes = "通过学生学号注销")
    @PostMapping("/deleteStuMsg")
    public String delete(@RequestParam @ApiParam( name = "id") String id ){

        if( studentService.deleteByPrimaryKey(id) != 0){
            return SqlUtils.success;
        }
        return SqlUtils.wrong;
    }
    @ApiOperation(value = "班级学生信息查询接口", notes = "查询某班级所有学生的信息")
    @PostMapping("/inquireStuMsgByClass")
    public String inquireByClass(@RequestParam @ApiParam( name = "classNo") String classNo ){
        List<Student> students = studentService.selectByClassNo(classNo);
        Map<String,String> map = SqlUtils.getMap();
        if(students == null || students.size() == 0){
            map.put("status","FAILURE");
            map.put("reason","no students in class or no such class!");
            return JSON.toJSONString(map);
        }
        map.put("students",JSON.toJSONString(students));
        return JSON.toJSONString(map);
    }
}
