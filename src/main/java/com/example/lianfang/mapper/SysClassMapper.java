package com.example.lianfang.mapper;

import com.example.lianfang.entity.SysClass;
import com.example.lianfang.entity.SysClassExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysClassMapper {
    int deleteByPrimaryKey(String classNo);

    int insert(SysClass record);

    int insertSelective(SysClass record);

    SysClass selectByPrimaryKey(String classNo);

    int updateByExampleSelective(@Param("record") SysClass record, @Param("example") SysClassExample example);

    int updateByExample(@Param("record") SysClass record, @Param("example") SysClassExample example);

    int updateByPrimaryKeySelective(SysClass record);

    int updateByPrimaryKey(SysClass record);
}