package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.Course;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.CourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api( description = "课程操作相关接口,教师调用  统一返回状态码")
@RestController("/course")
@ResponseBody
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;

    @ApiOperation(value = "添加课程信息",notes ="" )
    @PostMapping("/addcourse")
    public String add(@RequestBody @ApiParam Course course){
        if(courseService.selectByPrimaryKey(course.getCourNo()) != null){
            return SqlUtils.wrong;
        }
       if(courseService.insert(course) != 0){
           return SqlUtils.success;
       }
        return SqlUtils.wrong;
    }
    @ApiOperation(value = "修改课程相关信息", notes = "课程的课程号必填 其他属性 不是必填")
    @PostMapping("/modifycourse")
    public String modify(@RequestBody Course course){
        if(courseService.updateByPrimaryKeySelective(course) != 0){
            return SqlUtils.success;
        }
        return SqlUtils.wrong;
    }
    @ApiOperation(value = "课程注销接口", notes = "删除该课程 参数一个变量 不是JSON串")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "courNo", example = "5",paramType = "query")
    )
    @PostMapping("/deletecourse")
    public String delete(@RequestParam  String courNo){
        if(courNo == null){
            return SqlUtils.wrong;
        }
        if(courseService.deleteByPrimaryKey(courNo) != 0){
            return SqlUtils.success;
        }
        return SqlUtils.wrong;
    }
    @ApiOperation(value = "课程信息查询", notes = "查询相关信息 参数为课程号 若没有此课程 返回 null")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "courNo", example = "5",paramType = "query")
    )
    @PostMapping("/selectcourse")
    public String selectCourse(@RequestParam String courNo){
        return JSON.toJSONString(courseService.selectByPrimaryKey(courNo));
    }



}
