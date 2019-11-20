package com.example.lianfang.Controller;

import com.example.lianfang.entity.Student;
import com.example.lianfang.entity.Teacher;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if(studentService.selectByPrimaryKey(student.getId()) != null || studentService.insertSelective(student) == 0 ) return SqlUtils.wrong;
        return SqlUtils.success;
    }


}
