package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.User;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.FinalGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "学生成绩接口")
@RestController("/grade")
@ResponseBody
@CrossOrigin
public class GradeController {
    @Autowired
    FinalGradeService finalGradeService;

    @ApiOperation(value = "成绩测试", notes = "这是接口 ")
    @GetMapping("/test")
    public String addGradeByClassNo(@RequestBody @ApiParam(name = "成绩的JOSN数组",value = "") List<FinalGrade> list){
        return null;
    }

    @ApiOperation(value = "成绩录入(期中，期末成绩都通过此接口) 同时也可以作为各种成绩的修改接口(也支持修改功能)", notes = "参数是成绩的JOSN数组，每个对象需要的属性是有" +
            "id,courNo,classNo,year,term,(必需)," +
            "midExam,lastExam（选填） 字段根据要录入期中还是期末选填添加,然后其他字段无视")
    @PostMapping("/studentsGradeAdmit")
    public String studentsGradeAdmit(@RequestBody @ApiParam(name = "",value = "") List<FinalGrade> list){
        int changeRowCount = 0;
        Map<String,String> map = SqlUtils.getMap();
        for (int i = 0; i < list.size(); i++) {
            try{
                if(finalGradeService.selectByPrimaryKey(list.get(i)) != null){      // 此成绩已经录入过了
                    changeRowCount += finalGradeService.updateByPrimaryKeySelective(list.get(i));
                }
                else changeRowCount += finalGradeService.insertSelective(list.get(i));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        map.put("changedRow",String.valueOf(changeRowCount));
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "以班级为单位查询课程相关信息" +
            "四个参数 classNO,courNo,year,term (除classNo必填 其他选填)")
    @PostMapping("/studentsGradeInquire")
    public String studentsGradeInquire(@RequestBody @ApiParam(name = "",value = "") FinalGrade finalGrade){

        Map<String,String> map = SqlUtils.getMap();
            try{
               List<FinalGrade> list = finalGradeService.inquireStudentsGradesByClassOrCourNo(finalGrade);
               map.put("record",JSON.toJSONString(list));
            }
            catch (Exception e){
                e.printStackTrace();
                map.put("status","FAILURE");
                map.put("reason","System error!");
            }
        return JSON.toJSONString(map);
    }
    @ApiOperation(value = "单个学生根据学年学期成绩查询"
            ,notes =  "三个参数 id,year,term (除classNo必填 其他选填)" +
            "返回值： 该学年该学生所有成绩的JSON串")
    @PostMapping("/singleStudentGradeInquire")
    public String singleStudentGradeInquire(@RequestBody @ApiParam(name = "",value = "") FinalGrade finalGrade){

        Map<String,String> map = SqlUtils.getMap();
        try{
            List<FinalGrade> list = finalGradeService.singleStudentGradeInquire(finalGrade);
            if(list.size() == 0){
                map.put("status","FAILURE");
                map.put("reason","can't find this record");
            }
           else map.put("record",JSON.toJSONString(list));
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("status","FAILURE");
            map.put("reason","System error!");
        }
        return JSON.toJSONString(map);
    }












}
