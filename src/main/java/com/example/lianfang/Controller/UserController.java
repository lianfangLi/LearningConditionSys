package com.example.lianfang.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lianfang.entity.User;
import com.example.lianfang.generalUtils.SqlUtils;
import com.example.lianfang.generalUtils.Status;
import com.example.lianfang.service.TeacherService;
import com.example.lianfang.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "user相关接口 增删改操作均返回json格式的状态码 其他操作返回json的实体类")
@CrossOrigin
@RestController
@RequestMapping("/user")
@ComponentScan
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    TeacherService teacherService;

    /**
     *
     *
     *  学生Service操作
     * @param user
     * @return
     */


    @CrossOrigin
    @ApiOperation("用户登录接口")
    @PostMapping("/userLogin")
    public String login(@RequestBody @ApiParam(name = "user", value = "JSON的格式的用户信息 登陆成功 会返回一个identity的值") User user){
        User query = userService.login(user);
        Map<String,String> map = SqlUtils.getMap();
        if(query != null){
            map.put("identity",query.getIdentity());
           return JSON.toJSONString(map);
        }
       /* return SqlUtils.wrong;*/

        return SqlUtils.wrong;
    }

    @CrossOrigin
    @ApiOperation(value = "获取所有用户信息", notes = "这是接口")
    @GetMapping("/getUser")
    public String getUser(){
        List<User> users = userService.getAll();

        return JSON.toJSONString(users);
    }

    /**
     *  根据id 查询 用户信息接口
     * @param id
     * @return
     */
    /**
     *  查询用户信息 接口
     * @param id
     * @return
     */
    @ApiOperation("根据学号查询用户相关信息")
    @PostMapping("/getUserById")
    public String getUserById(@RequestParam(value = "id")  @ApiParam(name="id",value="用户id",required=true)String id){
        if(userService.getById(id) == null) return SqlUtils.wrong;

        ;
        return JSON.toJSONString(userService.getById(id));
    }
    @ApiOperation("删除用户接口")
    @PostMapping("/deleteUsers")
    public String delete(@RequestParam (value ="id") @ApiParam(name="id",value="用户id",required=true) String id){
        if(userService.deleteRecord(id) != 0){
            return SqlUtils.success;
        }

        return SqlUtils.wrong;
    }

    /**
     *   用户注册 接口
     * @param user
     * @return
     */
    @ApiOperation("用户注册接口")
    @PostMapping("/registerUsers")
    public String insertRecord(@RequestBody  @ApiParam(name="用户对象",value="传入json格式",required=true) User user){

        if (userService.getById(user.getId()) != null){      // 判断 该id是否注册过

            return SqlUtils.wrong;

        }
        userService.insertRecord(user);
        return SqlUtils.success;
    }

    @ApiOperation(value = "用户密码修改接口",notes = "注意传输格式")
    @PostMapping("/modifyUsers")
    public String update(@RequestParam  @ApiParam(name = "user",value =
            "账号密码JSON串 例：{\"id\": \"1\", \"pass\": \"123\" }") String user,
                         @RequestParam @ApiParam(name = "modifiedPass",value = "修改后的密码") String modifiedPass){
          Map map = SqlUtils.getMap();
          JSONObject JSONObject = JSON.parseObject(user);
          User temp = new User();
          temp.setId(JSONObject.getString("id"));
          temp.setPass(JSONObject.getString("pass"));
          temp = userService.login(temp);
          if(temp == null){                        // 该用户账号，密码错误
              map.put("status","FAILURE");
              map.put("reason","wrong password!");
              return JSON.toJSONString(map);
          }
          temp.setPass(modifiedPass);
        if(userService.updateRecord(temp) == 0){
            map.put("status","FAILURE");
            map.put("reason","password modify failed!!");
        }

            return SqlUtils.success;
    }




    @ApiOperation(value = "查询用户角色接口",notes = "用户只能拥有一种角色 要么 老师 要么学生")
    @PostMapping("/getUserRole")
    public String getRole(@RequestParam  @ApiParam("用户id") String userId){

            return null;
    }







}
