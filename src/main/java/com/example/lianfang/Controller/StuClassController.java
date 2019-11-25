package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lianfang.entity.StuClass;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.service.StuClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(description = "班级信息增删查改 接口 ")
@RestController("/stuClass")
@ResponseBody
@CrossOrigin
public class StuClassController {
    @Autowired
    StuClassService stuClassService;

    @ApiOperation(value = "添加班级信息", notes = "")
    @PostMapping("classMsgRegister")
    public String register(@RequestBody @ApiParam StuClass stuClass){
        StuClass StuClass = stuClassService.selectByPrimaryKey(stuClass.getClassNo());
        if(StuClass != null ){
            Map<String,String> map = new HashMap<>();
            map.put("status", "FAILURE");
            map.put("reason","claaaNo  has been used!");
            return JSON.toJSONString(map);
        }
        stuClassService.insert(stuClass);
        return JSON.toJSONString(SqlUtils.getMap());
    }

    @ApiOperation(value = "修改班级信息", notes = "修改班级 人数 ，导员信息等 班级号 无法修改,")
    @PostMapping("classMsgModify")
    public String modify(@RequestBody @ApiParam StuClass stuClass){
        StuClass StuClass = stuClassService.selectByPrimaryKey(stuClass.getClassNo());
        if(StuClass == null ){
            Map<String,String> map = new HashMap<>();
            map.put("status", SqlUtils.wrong);
            map.put("reason","no such class");
            return JSON.toJSONString(map);
        }
        stuClassService.updateByPrimaryKeySelective(stuClass);
        return JSON.toJSONString(SqlUtils.getMap());
    }
    @ApiOperation(value = "删除班级信息", notes = "根据班级号删除 某一班级 ")
    @PostMapping("classMsgDelete")
    public String delete(@RequestParam @ApiParam String classNo){
        int i= stuClassService.deleteByPrimaryKey(classNo);
        if(i == 0 ){
            Map<String,String> map = new HashMap<>();
            map.put("status", "FAILURE");
            map.put("reason","delete class failed!");
            return JSON.toJSONString(map);
        }
        stuClassService.deleteByPrimaryKey(classNo);
        return JSON.toJSONString(SqlUtils.getMap());
    }
    @ApiOperation(value = "查询班级信息", notes = "根据班级号查询 某一班级 ")
    @PostMapping("classMsgSearchByNo")
    public String classMsgSearchByNo(@RequestParam @ApiParam String classNo){
        Map<String,String> map = new HashMap<>();

        StuClass StuClass = stuClassService.selectByPrimaryKey(classNo);
        if(StuClass == null ){

            map.put("status", "FAILURE");
            map.put("reason","no such class!");
            return JSON.toJSONString(map);
        }
        map.put("status","SUCCESS");
        map.put("msg",JSON.toJSONString(StuClass));
        return JSON.toJSONString(map);
    }






}
