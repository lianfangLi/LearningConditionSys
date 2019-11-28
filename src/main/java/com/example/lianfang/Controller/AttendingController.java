package com.example.lianfang.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.lianfang.entity.Attending;

import com.example.lianfang.entity.Student;
import com.example.lianfang.entity.StudentAttending;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.AttendingService;
import com.example.lianfang.service.StuClassService;
import com.example.lianfang.service.StudentAttendingService;
import com.example.lianfang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
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
    @Autowired
    AttendingService attendingService;

    @ApiOperation(value = "创建某班考勤情况",notes = " 异常状态：无此班级，有班级该班级无学生，该次考勤已经添加过。 失败时后多返回一个fail字段表明失败原因 自己测试，" +
            "然后 科目 填 科目编号吧 别填科目名称了")
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
    @ApiOperation(value = "修改某班学生考勤情况",
            notes = " 这个接口 可以同时用来修改学生某次考勤的情况 可以把考勤设置为到了，或者未到，具体使用 自己看")
    @PostMapping("/modifyByClass")
    public String modifyByClassNO(@RequestParam @ApiParam(name = "students",
            value ="学生信息的JSON数组 例：{\"students\" : [{\"id\" : \"17111205000\", \"isAttend\" : \"0\"}]}" )
                                              String students,
                                  @RequestParam @ApiParam(name = "subject",value = "学科编号") String subject,
                                  @RequestParam @ApiParam(name ="whichTime",value = "那一次") String whichTime ){
        JSONObject JSONObject = JSON.parseObject(students);
        JSONArray jsonArray = (JSONArray)JSONObject.getJSONArray("students");
        List<Attending> attendings = (List<Attending>) JSONArray.parseArray(jsonArray.toString(),Attending.class); // 获取并修改学生数组
        Iterator<Attending> iter = attendings.iterator();
        while(iter.hasNext()){
            Attending temp = iter.next();
            temp.setWhichSubject(subject);
            temp.setWhichTime(Integer.parseInt(whichTime));
        }
        Map map = SqlUtils.getMap();
        try{
            int i = attendingService.updateAttendingSituation(attendings);
            if(i ==0){
                map.put("status","FAILURE");
                map.put("reason","check your class or times! ");
            }
            map.put("affected",String.valueOf(i));
        }
        catch (Exception e){
            map.put("status","FAILURE");
        }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "查看某班学生某次某学科考勤情况",
            notes = " model 里面 只需要 classNo whichTime whichSubject 字段 其他无视 返回 学生id以及是否考勤的json数组")
    @PostMapping("/checkByClass")
    public String checkByClassNO(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{
            List<Attending> attendings = attendingService.checkByClass(msg);
            if(attendings == null || attendings.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!");

            }
            else{
                map.put("students",JSON.toJSONString(attendings));
            }
        }
        catch(Exception e){
                map.put("status","FAILURE");
                map.put("reason","System error!");
        }

        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "删除某班学生某次某学科考勤情况",
            notes = " model 里面 只需要 classNo whichTime whichSubject 字段 其他无视 若没有该班级该班级该次考勤考勤记录 返回失败 否则 都返回成功")
    @PostMapping("/deleteByClass")
    public String deleteByClassNO(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{
            int attendings = attendingService.deleteByClass(msg);
            if(attendings  == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!");

            }

        }
        catch(Exception e){
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "查看某学生 某门科目考勤情况 (同时支持课程全部考勤纪律 以及某次)",
            notes = " model里面若查询某科目 只需要 classNo whichSubject字段 查询某次 添加一个whichTime 其他无视 若没有考勤记录 返回失败 否则 ")
    @PostMapping("/inquireByStu")
    public String inquireByStu(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{
            List<Attending> record= attendingService.selectByStuNo(msg);
            if(record == null || record.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!");

            }
            else {
                map.put("record",JSON.toJSONString(record));
            }

        }
        catch(Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }



}
