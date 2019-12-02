package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.Teacher;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(description = "教师信息操作相关接口，性别只有男和女 出生日期格式固定 职称也是只有几个选项（你们设的） 注意数据类型")
@RestController
@ResponseBody
@CrossOrigin
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation(value = "教师注册接口",notes = "id属性必填，其他选填")
    @PostMapping("/teacherRegister")
    public String registe(@RequestBody   Teacher teacher){
        if(teacherService.selectByPrimaryKey(teacher.getTeacherId()) != null || teacherService.insertSelective(teacher) == 0 ) return SqlUtils.wrong;
        return SqlUtils.success;
    }


    @ApiOperation(value = "教师信息修改接口",notes = "教师id必填 其他字段只需添加要更改的字段")
    @PostMapping("/teacherModify")
    public String modify(@RequestBody  @ApiParam(name = "教师实体类") Teacher teacher)
    {
            return teacherService.updateByPrimaryKeySelective(teacher) !=0 ? SqlUtils.success : SqlUtils.wrong;

    }

    @ApiOperation(value = "单个教师信息查询接口",notes = "返回单个教师的JSON串 若未查询到 返回null")
    @PostMapping("/teacherSelect")
    public String selectOne(@RequestParam @ApiParam(name = "id",example = "1") String id ){
            return JSON.toJSONString(teacherService.selectByPrimaryKey(id));

    }


    @ApiOperation(value = "院系教师查询信息接口",notes = "返回该院系教师的JSON数组 若未查询到 返回null")
    @PostMapping("/getTeacherByDp")
    public String selectAll(@RequestParam @ApiParam(name = "dpId",example = "1") Integer dpId){
        return JSON.toJSONString(teacherService.getTeachersByDpId(dpId));
    }






}
