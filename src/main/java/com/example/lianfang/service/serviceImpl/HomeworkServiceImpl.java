package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.HomeworkExtends;
import com.example.lianfang.entity.HomeworkKey;
import com.example.lianfang.mapper.HomeworkMapper;
import com.example.lianfang.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public int deleteByPrimaryKey(HomeworkKey key) {
        return homeworkMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(Homework record) {
        return homeworkMapper.insert(record);
    }

    @Override
    public int insertSelective(Homework record) {
        return homeworkMapper.insertSelective(record);
    }

    @Override
    public Homework selectByPrimaryKey(HomeworkKey key) {
        return selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(Homework record) {
        return homeworkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Homework record) {
        return updateByPrimaryKey(record);
    }

    @Override
    public int updateHomeworkSituation(List<Homework> list) {
        return updateHomeworkSituation(list);
    }

    @Override
    public List<Homework> checkByClass(Homework msg) {
        return homeworkMapper.checkByClass(msg);
    }

    @Override
    public int deleteByClass(Homework msg) {
        return homeworkMapper.deleteByClass(msg);
    }

    @Override
    public List<Homework> selectByClassAndTimes(Homework msg) {
        return homeworkMapper.selectByClassAndTimes(msg);
    }

    @Override
    public List<Homework> selectBystuYearAndTerm(Homework msg) {
        return selectBystuYearAndTerm(msg);
    }

    @Override
    public List<HomeworkExtends> selectBystuYearAndTermToGetTimes(Homework msg) {
        return homeworkMapper.selectBystuYearAndTermToGetTimes(msg);
    }
}
