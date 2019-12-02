package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.FinalGradeKey;
import com.example.lianfang.mapper.FinalGradeMapper;
import com.example.lianfang.service.FinalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalGradeServiceImpl implements FinalGradeService {

    @Autowired
    FinalGradeMapper finalGradeMapper;

    @Override
    public List<FinalGrade> checkIsClassRecordExists(FinalGrade record) {
        return finalGradeMapper.checkIsClassRecordExists(record);
    }

    @Override
    public int deleteRecordByClassAndCour(FinalGrade record) {
        return finalGradeMapper.deleteRecordByClassAndCour(record);
    }

    @Override
    public int deleteByPrimaryKey(FinalGradeKey key) {
        return finalGradeMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(FinalGrade record) {
        return finalGradeMapper.insert(record);
    }

    @Override
    public int insertSelective(FinalGrade record) {
        return finalGradeMapper.insertSelective(record);
    }

    @Override
    public FinalGrade selectByPrimaryKey(FinalGradeKey key) {
        return finalGradeMapper.selectByPrimaryKey(key);

    }

    @Override
    public int updateByPrimaryKeySelective(FinalGrade record) {
        return finalGradeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FinalGrade record) {
        return finalGradeMapper.updateByPrimaryKey(record);
    }
}
