package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel
public class StuClass {
    @ApiModelProperty(name = "classNo",example = "2")
    private String classNo;
    @ApiModelProperty(name = "className",example = "软件工程")
    private String className;
    @ApiModelProperty(name = "year",example = "2017-09-01")
    private Date year;
    @ApiModelProperty(name = "number",example = "50")
    private Integer number;
    @ApiModelProperty(name = "dpId",example = "17111205")
    private Integer dpId;
    @ApiModelProperty(name = "teacherNo",example = "Susan")
    private String teacherNo;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo == null ? null : teacherNo.trim();
    }
}