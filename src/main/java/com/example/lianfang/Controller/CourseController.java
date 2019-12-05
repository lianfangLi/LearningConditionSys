package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.Course;
import com.example.lianfang.entity.TeacherCourse;
import com.example.lianfang.entity.TeacherCourseExtends;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.CourseService;
import com.example.lianfang.service.TeacherCourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api( description = "课程操作相关接口,教师调用  统一返回状态码")
@RestController("/course")
@ResponseBody
@CrossOrigin
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherCourseService teacherCourseService;

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

    @ApiOperation(value = "教师添加班级课程信息", notes = "改接口 在教师关联班级时使用 ")

    @PostMapping("/addRelatedBetweenTeaAndStu")
    public String addRelatedBetweenTeaAndStu(@RequestBody TeacherCourse teacherCourse){
        Map map = SqlUtils.getMap();
        try{
            if(teacherCourseService.selectByPrimaryKey(teacherCourse) != null){
                map.put("status","FAILURE");
                map.put("reason","record exist!");
            }
            teacherCourseService.insertSelective(teacherCourse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "根据教师id学年学期查询班级以及课程号", notes = "教师查询所授课程班级相关信息 \n" +
            "teacherId 必填字段 \n" +
            "year term 选填 其他字段pass")
    @PostMapping("/inqueireClassAndCourByTeaIdAndYearAndTerm")
    public String inqueireClassAndCourByTeaIdAndYearAndTerm(@RequestBody TeacherCourse teacherCourse){
        Map map = SqlUtils.getMap();
        try{
           List<TeacherCourse> list = teacherCourseService.inquireClassAndCourByTeaIdAndYearAndTerm(teacherCourse);
           if(list == null || list.size() == 0){
               map.put("status","FAILURE");
               map.put("reason","no such record!");
           }
           else{
               map.put("record",JSON.toJSONString(list));
           }
        }catch (Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "根据班级查询该班级某学年学期所有课程相关情况", notes = "classNo 必填 \n" +
            "year term 选填 \n" +
            "其他字段无视")
    @PostMapping("/inqueireCourByclass")
    public String inqueireCourByclass(@RequestBody TeacherCourse teacherCourse){
        Map map = SqlUtils.getMap();
        try{
                List<TeacherCourseExtends> list = teacherCourseService.inqueireCourByclass(teacherCourse);
            if(list == null || list.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!");
            }
            else{
                map.put("record",JSON.toJSONString(list));
            }

        }catch (Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }

}
