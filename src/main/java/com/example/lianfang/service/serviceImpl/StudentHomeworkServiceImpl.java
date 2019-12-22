package com.example.lianfang.service.serviceImpl;

import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.HomeworkExtends;
import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.Student;
import com.example.lianfang.generalUtils.GradeComputeUtils;
import com.example.lianfang.mapper.HomeworkMapper;
import com.example.lianfang.mapper.FinalGradeMapper;
import com.example.lianfang.mapper.StudentHomeworkMapper;
import com.example.lianfang.service.FinalGradeService;
import com.example.lianfang.service.StudentHomeworkService;
import com.sun.tools.internal.xjc.model.CTypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentHomeworkServiceImpl implements StudentHomeworkService {


    @Autowired
    StudentHomeworkMapper studentHomeworkMapper;

    @Autowired
    HomeworkMapper homeworkMapper;

    @Autowired
    FinalGradeMapper finalGradeMapper;

    @Override
    public int insertByClassNo(List<Student> stuList, String year, String term, String sub, Integer time, String isattend,String class_no) {
        int count = studentHomeworkMapper.insertByClassNo(stuList,year,term,sub,time,isattend,class_no);
        // 成绩表中考勤成绩修改操作
        try{
            List<Homework> record = GradeComputeUtils.getClassHomeworkRecords(stuList,year,term,sub,class_no);
            this.finalGradeModify(record);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
    @Override
    public List<Homework> selectIsHomeworkExist(Homework homework) {
        return studentHomeworkMapper.selectIsHomeworkExist(homework);
    }


    public void finalGradeModify(List<Homework> record){
        List<FinalGrade> finalGrades = GradeComputeUtils.ConvertFromHomeworkToFinalGrade(record);
        if(record.get(0).getClassNo() != null){
            FinalGrade finalGrade = new FinalGrade();
            finalGrade.setClassNo(record.get(0).getClassNo());                  // 查询班级该科目的成绩表是否创建
            finalGrade.setCourNo(record.get(0).getWhichSubject());
            List<FinalGrade> finalGradesInquire = finalGradeMapper.selectByClassNoAndCourNo(finalGrade);

            if(finalGradesInquire== null || finalGradesInquire.size() == 0){                  // 若没有创建该成绩表 首先创建记录
                for (int i = 0; i < finalGrades.size(); i++) {
                    finalGradeMapper.insertSelective(finalGrades.get(i));
                }
            }
        }
        for (int i = 0; i <record.size() ; i++) {      // 对成绩表中的考勤成绩有修改的记录做修改
            List<HomeworkExtends> homeworkExtendsList = homeworkMapper.selectByStuIdAndYearAndTermAndSubjectToGetTimes(record.get(i));
            float attend_yes = 0;
            float attend_no = 0;
            for (int j = 0; j <homeworkExtendsList.size(); j++) {
                if(homeworkExtendsList.get(j).getIsAttend().equals( "0")){
                    attend_no += homeworkExtendsList.get(j).getIsAttendResult();
                }
                else if(homeworkExtendsList.get(j).getIsAttend().equals("1"))
                    attend_yes += homeworkExtendsList.get(j).getIsAttendResult();
                else ;
            }
            if( attend_no + attend_yes != 0){
                float attend_grade = (attend_yes / ( attend_no + attend_yes)) *100 ;
                finalGrades.get(i).setCheckHomeaworkAttendance(attend_grade);
                finalGradeMapper.updateAttending(finalGrades.get(i));
            }
        }
    }
}
