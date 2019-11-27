package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.AttendingKey;
import com.example.lianfang.mapper.AttendingMapper;
import com.example.lianfang.service.AttendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendingServiceImpl implements AttendingService {
    @Autowired
    AttendingMapper attendingMapper;
    @Override
    public int deleteByPrimaryKey(AttendingKey key) {
        return attendingMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(Attending record) {
        return attendingMapper.insert(record);
    }

    @Override
    public int insertSelective(Attending record) {
        return attendingMapper.insertSelective(record);
    }

    @Override
    public Attending selectByPrimaryKey(AttendingKey key) {
        return attendingMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(Attending record) {
        return attendingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Attending record) {
        return attendingMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByClass(Attending msg) {
        return attendingMapper.deleteByClass(msg);
    }

    @Override
    public List<Attending> checkByClass(Attending msg) {
        return attendingMapper.checkByClass(msg);
    }

    @Override
    public int updateAttendingSituation(List<Attending> list) {
        return attendingMapper.updateAttendingSituation(list);
    }
}
