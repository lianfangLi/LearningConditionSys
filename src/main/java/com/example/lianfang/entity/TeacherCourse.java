package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TeacherCourse extends TeacherCourseKey {
    @ApiModelProperty(name ="classNo", example = "2")
    private String classNo;
    @ApiModelProperty(name ="courName", example = "高等数学")
    private String courName;
    @ApiModelProperty(name ="year", example = "第一学年")
    private String year;
    @ApiModelProperty(name ="term", example = "第一学期")
    private String term;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName == null ? null : courName.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }
}