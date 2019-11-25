package com.example.lianfang.mapper;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentAttendingMapper {
/*    int selecttByclassNo(@Param("classNo") String classNo,@Param("subject") String subject,@Param("time") String time);*/

    int insertByClassNo(@Param("stuList") List<Student> stuList,
                        @Param("year") String year,
                        @Param("term") String term,
                        @Param("subject") String sub,
                        @Param("time") Integer time,
                        @Param("isattend") String isattend,
                        @Param("classNo") String class_no
    );
    Attending selectByPrimaryKey();
    List<Attending> selectIsAttendingExist(Attending attending );
}
