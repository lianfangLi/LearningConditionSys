package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.StuClass;
import com.example.lianfang.mapper.StuClassMapper;
import com.example.lianfang.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuClassServiceImpl implements StuClassService {

    @Autowired
    StuClassMapper stuClassMapper;



    @Override
    public int deleteByPrimaryKey(String classNo) {
        return stuClassMapper.deleteByPrimaryKey(classNo);
    }

    @Override
    public int insert(StuClass record) {
        return stuClassMapper.insert(record);
    }

    @Override
    public int insertSelective(StuClass record) {
        return stuClassMapper.insertSelective(record);
    }

    @Override
    public StuClass selectByPrimaryKey(String classNo) {

        return stuClassMapper.selectByPrimaryKey(classNo);
    }

    @Override
    public int updateByPrimaryKeySelective(StuClass record) {
        return stuClassMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StuClass record) {
        return updateByPrimaryKey(record);
    }
}
