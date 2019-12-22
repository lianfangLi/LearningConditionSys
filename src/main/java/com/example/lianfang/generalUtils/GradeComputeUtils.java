package com.example.lianfang.generalUtils;

import com.example.lianfang.entity.Attending;
import com.example.lianfang.entity.FinalGrade;
import com.example.lianfang.entity.Homework;
import com.example.lianfang.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用计算类
 * @author 连方
 */
public class GradeComputeUtils {
    /**
     * 将Student对象封装成 Attending对象
     * @param students
     * @param year
     * @param term
     * @param sub
     * @param class_no
     * @return
     */
    public static List<Attending>
    getClassAttendingRecords(List<Student> students, String year, String term,  String sub,String class_no){
        List<Attending> result = new ArrayList();

        for (int i = 0; i < students.size(); i++) {
            Attending stu = new Attending();
            stu.setId(students.get(i).getId());
            stu.setWhichYear(year);
            stu.setWhichTerm(term);
            stu.setWhichSubject(sub);
            stu.setClassNo(class_no);
            result.add(stu);
        }
        return result;
    }
    public static List<FinalGrade>
    ConvertFromAttendingToFinalGrade(List<Attending> students ){
        List<FinalGrade> result = new ArrayList();

        for (int i = 0; i < students.size(); i++) {
            FinalGrade stu = new FinalGrade();
            stu.setId(students.get(i).getId());
            if(students.get(i).getWhichYear() != null){
                stu.setYear(students.get(i).getWhichYear());
            }

            stu.setTerm(students.get(i).getWhichTerm());
            stu.setCourNo(students.get(i).getWhichSubject());
            stu.setClassNo(students.get(i).getClassNo());
            result.add(stu);
        }

        return result;
    }

    public static List<Homework>
    getClassHomeworkRecords(List<Student> students, String year, String term,  String sub,String class_no){
        List<Homework> result = new ArrayList();
        for (int i = 0; i < students.size(); i++) {
            Homework stu = new Homework();
            if(students.get(i).getId()!= null)
            stu.setId(students.get(i).getId());
            stu.setWhichYear(year);

            if(students.get(i).getId()!= null)
            stu.setWhichTerm(term);

            stu.setWhichSubject(sub);
            stu.setClassNo(class_no);
            result.add(stu);
        }
        return result;
    }

    public static List<FinalGrade>
    ConvertFromHomeworkToFinalGrade(List<Homework> students ){
        List<FinalGrade> result = new ArrayList();

        for (int i = 0; i < students.size(); i++) {
            FinalGrade stu = new FinalGrade();
            stu.setId(students.get(i).getId());

            stu.setYear(students.get(i).getWhichYear());
            stu.setTerm(students.get(i).getWhichTerm());
            stu.setCourNo(students.get(i).getWhichSubject());
            stu.setClassNo(students.get(i).getClassNo());
            result.add(stu);
        }
        return result;
    }



}

