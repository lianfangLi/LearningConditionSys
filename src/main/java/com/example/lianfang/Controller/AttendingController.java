package com.example.lianfang.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.lianfang.entity.Attending;

import com.example.lianfang.entity.AttendingExtends;
import com.example.lianfang.entity.Student;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.mapper.AttendingMapper;
import com.example.lianfang.mapper.StudentAttendingMapper;
import com.example.lianfang.service.AttendingService;
import com.example.lianfang.service.StuClassService;
import com.example.lianfang.service.StudentAttendingService;
import com.example.lianfang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Api(description = "学生考勤与作业相关接口")
@RestController("/attend/")
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
    @Autowired
    AttendingMapper AttendingMapper;

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
            notes = " 参数为JSON数组 每个对象有四个字段 id，isAttend,whichSubject,whichTime 必填 ")
    @PostMapping("/modifyByClass")
    public String modifyByClassNO(@RequestBody List<Attending> list ){
        Map map = SqlUtils.getMap();
        try{
            int i = 0;
            for (int j = 0; j <list.size() ; j++) {
                i += attendingService.updateByPrimaryKeySelective(list.get(j));
            }
            if(i ==0){
                map.put("status","FAILURE");
                map.put("reason","check your class or times,no record had been changed! ");
            }
            map.put("affected",String.valueOf(i));

            // 修改成绩表操作

            studentAttendingService.finalGradeModify(list);

        }
        catch (Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
        }


        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "查看某班所有学生某学科某次考勤情况",
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
    @ApiOperation(value = "查看某班级所有学生某门科目某一次考勤情况 ",
            notes = "   classNo whichSubject，whichTime字段 必填 其他无视 若没有考勤记录 返回失败  ")
    @PostMapping("/inquireByClass")
    public String inquireByClass(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{
            List<Attending> record= attendingService.selectByClassAndTimes(msg);

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
    /**
     *   该操作使用mysql的存储过程  进行 操作
     * @param msg
     * @return
     */
    @ApiOperation(value = "查看学生某一学年学期单一科目（按次数）考勤情况 该接口 有点复杂)",
            notes = " model里面 id（必填）  whichTerm,whichhYear字段也要填写 不然会返回学生所有的考勤纪律 其他无视" +
                    "返回值可能需要你们可能需要花点时间理解，若查询成功 返回两个字段 第一个字段 status 判断查询是否成功 " +
                    "第二个字段 recordDetail JSON数组 每个JSON对象属性有：courName,whichSubject,whichTime,isAttend（0或1）   "
                    )
    @PostMapping("/selectBystuYearAndTermAndSubject")
    public String selectBystuYearAndTermAndSubject(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{

           List<Attending> list = attendingService.selectBystuYearAndTerm(msg);
            if(list == null || list.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!!");
            }
            else {
                map.put("recordDetail",JSON.toJSONString(list));
             //   map.put("recordGeneral",JSON.toJSONString(list1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "查看学生某一学年学期所有科目（按每门科目缺勤率）考勤情况 该接口 有点复杂)",
            notes = " model里面 id（必填）  whichTerm,whichhYear,which_subject字段也要填写  其他无视" +
                    "若查询成功 返回两个字段 第一个字段 status 判断查询是否成功 " +
                    "第二个字段 recordGeneral JSON数组 每个JSON对象属性有：courName,whichSubject,isAttend（0或1） 或 AttendingResult  没有考勤率 考勤率 自己算  "
    )
    @PostMapping("/selectBystuYearAndTerm")
    public String selectBystuYearAndTerm(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        try{
            List<AttendingExtends> list1 = attendingService.selectBystuYearAndTermToGetTimes(msg);
            if(list1 == null || list1.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","no such record!!");
            }
            else {
                //   map.put("recordDetail",JSON.toJSONString(list));
                map.put("recordGeneral",JSON.toJSONString(list1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "Test)",
            notes = " model里面 id（必填）  whichTerm,whichhYear,which_subject字段也要填写  其他无视" +
                    "若查询成功 返回两个字段 第一个字段 status 判断查询是否成功 " +
                    "第二个字段 recordGeneral JSON数组 每个JSON对象属性有：courName,whichSubject,isAttend（0或1） 或 AttendingResult  没有考勤率 考勤率 自己算  "
    )
    @PostMapping("/test")
    public String selectBystuYear(@RequestBody @ApiParam(name = "msg") Attending msg){
        Map<String,String> map = SqlUtils.getMap();
        map.put("sd", JSON.toJSONString(AttendingMapper.selectByStuIdAndYearAndTermAndSubjectToGetTimes(msg)));
        List<Attending> list = new ArrayList<Attending>();
        list.add(msg);
        studentAttendingService.finalGradeModify(list);

        return JSON.toJSONString(map);
    }



}
