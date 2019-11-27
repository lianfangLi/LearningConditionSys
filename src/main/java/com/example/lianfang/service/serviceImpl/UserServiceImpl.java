package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.User;
import com.example.lianfang.mapper.UserMapper;
import com.example.lianfang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAll() {

        return userMapper.getAll();
    }
    public User getById(String id){
        return this.userMapper.getById(id);

    }

    @Override
    public Integer insertRecord(User user) {
          return userMapper.insertRecord(user);
    }

    @Override
    public Integer updateRecord(User user) {
        return userMapper.updateRecord(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer deleteRecord(String id) {
        return userMapper.deleteRecord(id);
    }


}
