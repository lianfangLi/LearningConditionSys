package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.User;
import com.example.lianfang.service.FinalGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "成绩录入(期中，期末成绩都通过此接口)", notes = "参数是成绩的JOSN数组，每个对象需要的属性是有" +
            "id,courNo,classNo,year,term,(必需)," +
            "midExam,lastExam（选填） 字段根据要录入期中还是期末选填添加,然后其他字段无视")
    @PostMapping("/studentsGradeAdmit")
    public String studentsGradeAdmit(@RequestBody @ApiParam(name = "",value = "") List<FinalGrade> list){

        return JSON.toJSONString(list);
    }












}
